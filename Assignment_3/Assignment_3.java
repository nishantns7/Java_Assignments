import java.io.*;

class PingMedian {
	public static void main(String[] args)throws IOException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of times to ping");
		int n = Integer.parseInt(buff.readLine());
		System.out.println("Enter the site/IP address to ping");
		Process p = Runtime.getRuntime().exec("ping -c " + n + " " + buff.readLine());
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String s = "" , pingResult = "", time = "";
		double ping[] = new double[n];
		int c = 0;
		while ((s = br.readLine()) != null) {
			pingResult += s;
		}
		String[] fields = pingResult.split(" " , 0);
		for(String i : fields) {
			if(i.contains("time=")) {
				time=i.substring(5);
				if(time.contains(".")) {
					ping[c] = Double.parseDouble(time);
					c++;
				}
				else {
					ping[c] = (double)Integer.parseInt(time);
					c++;
				}
			}
		}
		if(n % 2 == 0) {
			double median = (ping[n/2-1] + ping[n/2]) / 2;
			System.out.println("The median of the ping times is: " + median);
		}
		else
			System.out.println("The median of the ping times is: " + ping[n/2]);
	}
}
