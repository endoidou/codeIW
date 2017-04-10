import java.util.*;

public class CodeIQ {

	public static void main(String[] args) {

		//標準入力
		String[] input_frac = ScanBunsu();
		
		//入力を分数クラスに置き換える
		Fraction frac1 = StringToFraction(input_frac[0]);
		Fraction frac2 = StringToFraction(input_frac[1]);
		
		if (frac1 == null || frac2 == null) {
			System.out.print("入力が不正です");
			return;
		}
		
		//加算
		Fraction result = AddFrac(frac1, frac2);
		
		//
		result.printText();
	}
	
	
	//////////////////////////////////////////////////////////////////
	// Private Field
	//////////////////////////////////////////////////////////////////
	
	/**
	 * 二件の標準入力を行う
	 * @return String[] str = {"1/3","3/5"}
	 */
	private static String[] ScanBunsu() {
		String[] inputFrac = new String[2];
		Scanner cin = new Scanner(System.in);
		String line;
		for (int i = 0; cin.hasNext(); i++) {
			line = cin.nextLine();
			inputFrac[i] = line;
			if (i == 1)
				break;
		}
		return inputFrac;
	}

	/**
	 * 分数の足し算を行う
	 * 
	 * @param bunsu1
	 * @param bunsu2
	 * @return bunsu1 + bunsu2
	 */
	private static Fraction AddFrac(Fraction bunsu1, Fraction bunsu2) {
		
		if (bunsu1 == null || bunsu2 == null) {
			return null;
		}
		
		Fraction result = new Fraction();
		result.denom = bunsu1.denom * bunsu2.denom;
		result.numer = bunsu1.numer * bunsu2.denom + bunsu2.numer * bunsu1.denom;

		return Yakubun(result);
	}

	/**
	 * stringを分数に変更し、約分して返す
	 * 
	 * @param string ex) "2/6"
	 * @return 約分済み分数クラス Fraction(numer = 1,denom = 3)
	 */
	private static Fraction StringToFraction(String fractionStr) {
		String[] fractionArray = fractionStr.split("/", 0);
		
		// 分母がゼロの場合null
		if (fractionArray[1].equals("0")) {
			return null;
		}

		Fraction bunsu = new Fraction();
		bunsu.numer = Integer.parseInt(fractionArray[0]);
		bunsu.denom = Integer.parseInt(fractionArray[1]);
		return Yakubun(bunsu);
	}

	/**
	 * Fractionクラスを約分する
	 * 
	 * @param inputBunsu
	 * @return 約分されたFraction
	 */
	private static Fraction Yakubun(Fraction fraction) {

		// 分母が0だった場合エラーを返す
		if (fraction == null) {
			return null;
		}

		if (fraction.denom == fraction.numer) {
			fraction.denom = 1;
			fraction.numer = 1;
			return fraction;
		}

		int i = fraction.numer <= fraction.denom ? fraction.numer : fraction.denom;
		for (; i > 1; i--) {
			if (fraction.numer % i == 0 && fraction.denom % i == 0) {
				fraction.numer /= i;
				fraction.denom /= i;
			}
		}

		return fraction;
	}

	
	//////////////////////////////////////////////////////////////////
	// Inner Class
	//////////////////////////////////////////////////////////////////
	
	/**
	 * 分数クラス
	 */
	private static class Fraction {
		/** 分子 */
		int numer;
		/** 分母 */
		int denom;
		
		/**
		 * 分数を出力する
		 */
		public void printText() {
			if (this.numer == this.denom) {
				System.out.println("1");
			} else {
				System.out.println(this.numer + "/" + this.denom);
			}
		}
	}
	
}
