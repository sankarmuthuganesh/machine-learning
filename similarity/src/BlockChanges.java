import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class BlockChanges {
	private List<String> removedLines=new ArrayList<>();
	private List<String> addedLines=new ArrayList<>();
}
