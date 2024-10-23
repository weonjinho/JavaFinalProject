package makeData;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetNowDate {
	private String nowTime = null;
	public String GetNowDate() {
		SimpleDateFormat dFormat = new SimpleDateFormat("yyMM");
		Date now = new Date();
		nowTime = dFormat.format(now);
		System.out.println();
		System.out.println("--- GetNowDate 시작---");
		System.out.println("현재 사간 : " + nowTime);
		System.out.println("--- GetNowDate 끝 ---");
		return nowTime;
	}
}
