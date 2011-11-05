package roadrunner.server.logger;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Locale;

public class Logger {
	public static boolean log = false;
	//BufferedWriter out = new BufferedWriter(
	
	public static void log(String action, Object message, int id){
		if(log){
			StringBuilder sb = buildActionLog(action, id);
			
			sb.append(": ");
			sb.append("***");
			sb.append(message);
			sb.append("***");
			
			System.out.println(sb);
		}
	}

	public static void log(String action, int id){
		if(log){
			
			System.out.println(buildActionLog(action, id));
		}
	}

	private static StringBuilder buildActionLog(String action, int id) {
		Calendar calendar = Calendar.getInstance(new Locale("en"));
		StringBuilder sb = new StringBuilder(calendar.getTime().toString());
		sb.append("[").append(id).append("]");
		sb.append(" : ");
		sb.append(action);
		return sb;
	}
}
