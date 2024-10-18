package makeData;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetNowDate {
	private String nowTime = null;
	public String GetNowDate() {
		SimpleDateFormat dFormat = new SimpleDateFormat("yyMM");
		Date now = new Date();
		nowTime = dFormat.format(now);
		System.out.println("현재 사간 : " + nowTime);
		return nowTime;
	}
}
