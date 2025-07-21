package common_functions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotepadManager {
//	private static final String FILE_PATH = "src/test/resources/OnHoldSystem.txt";

	private NotepadManager() {
	}

	public static void ReadWriteNotepad(String fileName, Map<String, Object> data) throws IOException {
		Path path = Paths.get("src/test/resources/" + fileName);
		System.out.println(path.getParent());
		Files.createDirectories(path.getParent());
		
		if (!Files.exists(path)) {
			Files.createFile(path);
			System.out.println("File created: " + path.toString());
		} else {
			String existingcontent = new String(Files.readAllBytes(path));
			System.out.println("Existing lines are " + existingcontent);
		}

		/*********************************
		 * Write to notepad
		 *********************************/
		StringBuilder content = new StringBuilder();
		for (Entry<String, Object> entry : data.entrySet()) {
			content.append(" \"").append(entry.getKey()).append("\" = ");
			Object value = entry.getValue();
			if (value instanceof List) {
				List<?> list = (List<?>) value;
				content.append("[");
				for (int i = 0; i < list.size(); i++) {
					content.append("\"").append(list.get(i)).append("\"");

					if (i < list.size() - 1) {
						content.append(",");
					}
				}
				content.append("]");
			} else {
				content.append("\"").append(value).append("\"");
			}
			content.append(System.lineSeparator());
		}
		content.append("---------------------------------------").append(System.lineSeparator());
		Files.write(path, content.toString().getBytes(), StandardOpenOption.APPEND);
		System.out.println("File updated with value");
	}

	/*********************************
	 * Get the output as a list from OnHold
	 *********************************/
	public static List<String> GetMaterialIDs(String fileName) throws IOException {
		Path path = Paths.get("src/test/resources/" + fileName);
		if (!Files.exists(path)) {
			System.out.println("File not found: " + fileName);
			return Collections.emptyList();
		}

		List<String> lines = Files.readAllLines(path);
		Pattern pattern = Pattern.compile("\"Material ID\"\\s*=\\s*\"([^\"]+)\"");
		List<String> materialIds = new LinkedList<>();

		for (String line : lines) {
			Matcher matcher = pattern.matcher(line);
			if (matcher.find()) {
				materialIds.add(matcher.group(1));
			}
		}
		return materialIds;
	}

}