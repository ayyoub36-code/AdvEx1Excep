
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ThreadTime {

	public static void main(String[] args) {

		// TODO e une horloge qui affiche l’heure, les minutes et les secondes en
		// temps réel donc le tout doit défiler comme une montre digitale.
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Thread thread = new Thread(new MonRunnable(1000));
		// System.out.println(df.format(new Date()));
		thread.start();

	}

	private static class MonRunnable implements Runnable {

		private long delai;
		private DateFormat date = new SimpleDateFormat("HH:mm:ss");

		public MonRunnable(long delai) {

			this.delai = delai;
		}

		public static String setTime(DateFormat date) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeZone(date.getTimeZone());

			int hours = calendar.get(Calendar.HOUR_OF_DAY);
			int minutes = calendar.get(Calendar.MINUTE);
			int seconds = calendar.get(Calendar.SECOND);

			if (seconds == 59) {
				calendar.set(Calendar.SECOND, 0); // seconds = 0;
				calendar.add(Calendar.MINUTE, 1);
			} else {
				calendar.add(Calendar.SECOND, 1);
			}
			if (minutes == 59) {
				calendar.set(Calendar.MINUTE, 0);
				calendar.add(Calendar.HOUR, 1);
			} else {
				calendar.add(Calendar.MINUTE, 1);
			}
			if (hours == 23) {
				calendar.set(Calendar.HOUR_OF_DAY, 0);
			}
			return date.format(calendar.getTime());

		}

		@Override
		public void run() {
			while (true) {
				try {
					// modif second
					Thread.sleep(delai);
					System.out.print(setTime(date) + "\r");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
