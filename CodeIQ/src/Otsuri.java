import java.util.Scanner;

/**
 * 小銭王子
 * @author jun
 *
 */
public class Otsuri {
	private static final int YEN_500 = 500;
	private static final int YEN_100 = 100;
	private static final int YEN_50 = 50;
	private static final int YEN_10 = 10;
	private static final int YEN_5 = 5;

	public static void main(String[] args) {
		// 標準入力
		int input = Integer.parseInt(Stdin());

		int cnt = 0;

		int cnt_calc = 0;
		
		int i_max = (input / YEN_500) >= 1000 ? 1000 : input / YEN_500;
		int j_max = (input / YEN_100) >= 1000 ? 1000 : input / YEN_100;
		int k_max = (input / YEN_50) >= 1000 ? 1000 : input / YEN_50;
		int l_max = (input / YEN_10) >= 1000 ? 1000 : input / YEN_10;
		int m_max = (input / YEN_5) >= 1000 ? 1000 : input / YEN_5;
		int n_max = (input >= 1000) ? 1000 : input;
		
		loop_i: for (int i = i_max; i >= 0; i--) {
			loop_j: for (int j = j_max; j >= 0; j--) {
				loop_k: for (int k = k_max; k >= 0; k--) {
					if (i * YEN_500 + j * YEN_100 > input) {
						continue loop_j;
					}
					loop_l: for (int l = l_max; l >= 0; l--) {
						if (i * YEN_500 + j * YEN_100 + k * YEN_50 > input) {
							continue loop_k;
						}
						loop_m: for (int m = m_max; m >= 0; m--) {
							if (i * YEN_500 + j * YEN_100 + k * YEN_50 + l * YEN_10 > input) {
								continue loop_l;
							}
							loop_n: for (int n = n_max; n >= 0; n--) {
								cnt_calc++;
								if (i * YEN_500 + j * YEN_100 + k * YEN_50 + l * YEN_10 + m * YEN_5 > input) {
									continue loop_m;
								}
								if (input - (i * YEN_500 + j * YEN_100 + k * YEN_50 + l * YEN_10 + m * YEN_5) <= n_max) {
									cnt++;
									continue loop_m;
								}
							}
						}
					}
				}
			}
		}

		System.out.println(cnt + " " + cnt_calc);
	}

	/**
	 * 標準入力
	 */
	private static String Stdin() {
		Scanner cin = new Scanner(System.in);
		String line = "";
		for (; cin.hasNext();) {
			line = cin.nextLine();
			return line;
		}
		return line;
	}
}
