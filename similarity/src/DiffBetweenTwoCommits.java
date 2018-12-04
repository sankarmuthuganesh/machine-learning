import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.diff.DiffAlgorithm;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.diff.EditList;
import org.eclipse.jgit.diff.RawTextComparator;
import org.eclipse.jgit.diff.DiffAlgorithm.SupportedAlgorithm;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class DiffBetweenTwoCommits {
	public static void main(String[] args) throws Exception {
		Repository repository = new FileRepositoryBuilder().setGitDir(new File("C:\\Gravity\\Clones\\Temp\\hue-scm-sales\\river\\.git")).build();
		// Here we get the head commit and it's first parent.
		// Adjust to your needs to locate the proper commits.
		RevCommit headCommit = getHeadCommit(repository);
		RevCommit diffWith = headCommit.getParent(0);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DiffFormatter diffFormatter = new DiffFormatter(out);
		diffFormatter.setRepository(repository);
		diffFormatter.setDiffComparator(RawTextComparator.DEFAULT);
		diffFormatter.setDetectRenames(true);
		List<DiffEntry> diffs = diffFormatter.scan(diffWith, headCommit);
		int filesChanged = diffs.size();
		System.out.println(filesChanged + " files changed");
		Map<String,List<String>> removedLines = new HashMap<>();
		for (DiffEntry diff : diffs) {
//			EditList editsInFile = diffFormatter.toFileHeader(diff)
//					.toEditList();
			diffFormatter.format(diffFormatter.toFileHeader(diff));
			Iterator<String> lines = Arrays.stream(out.toString().split("\n")).iterator();
			List<String> buggyLines=new ArrayList<>();
			while (lines.hasNext()) {
				String currentLine = lines.next();
				try {
					if (currentLine.startsWith("-") && currentLine.charAt(1) != '-') {
						buggyLines.add(currentLine.substring(1).trim());
					}
				} catch (StringIndexOutOfBoundsException e) {
				}
			}
			removedLines.put(diff.getNewPath(),buggyLines);
			out.reset();
		}
		removedLines.entrySet().removeIf(file -> file.getValue().isEmpty());
		removedLines.entrySet().stream().forEach(k ->{
			System.out.println("************************************************************");
			System.out.println(k.getKey());
			System.out.println(k.getValue());
		});
	}

	private static RevCommit getHeadCommit(Repository repository)
			throws Exception {
		try (Git git = new Git(repository)) {
			Iterable<RevCommit> history = git.log().setMaxCount(1).call();
			return history.iterator().next();
		}
	}
}