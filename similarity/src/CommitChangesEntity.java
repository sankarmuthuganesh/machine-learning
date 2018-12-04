import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class CommitChangesEntity {
private String filePath;
private Map<String,List<BlockChanges>> changes;
}
