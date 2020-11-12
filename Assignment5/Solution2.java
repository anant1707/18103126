public class Solution2 extends Thread {

	public static long maxD = 0;
	public static long num = 0;

	public long start;

	public Solution2(long s) {
		this.start = s;
	}

	public void run() {
		for(long i = this.start; i<=this.start+10000; i++) {
			long currD=0;
            for(long j=i; j>0; j--)
            {
                if(i%j==0)
                {
                    currD+=1;
                }
            }
            if(currD > maxD)
            {
            	synchronized(this) {
            		maxD = currD;
	                num = i;
            	}
            }
		}
	}

	public static void main(String[] args) {
		Solution2 thr1 = new Solution2(1);
		Solution2 thr2 = new Solution2(10001);
		Solution2 thr3 = new Solution2(20001);
		Solution2 thr4 = new Solution2(30001);
		Solution2 thr5 = new Solution2(40001);
		Solution2 thr6 = new Solution2(50001);
		Solution2 thr7 = new Solution2(60001);
		Solution2 thr8 = new Solution2(70001);
		Solution2 thr9 = new Solution2(80001);
		Solution2 thr10 = new Solution2(90001);

		long st = System.currentTimeMillis();

		thr1.start();
		try {
			thr1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thr2.start();
		try {
			thr2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thr3.start();
		try {
			thr3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thr4.start();
		try {
			thr4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thr5.start();
		try {
			thr5.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thr6.start();
		try {
			thr6.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thr7.start();
		try {
			thr7.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thr8.start();
		try {
			thr8.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thr9.start();
		try {
			thr9.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thr10.start();
		try {
			thr10.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long total_time = System.currentTimeMillis() - st;

		System.out.println("Number =  " + num + " Divisors = " + maxD);
        System.out.println("Total time elapsed in milliseconds: " + (total_time));
	}
}