package coinpurse;

/**
 * 
 * a BankNote with a monetary value and currency
 * 
 * @author Thitiwat Thongbor
 *
 */
public class BankNote implements Comparable<BankNote>, Valuable {

	/** Default currency when there is no currency in constructor. */
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	private final double value;
	/** The currency, of course. */
	private final String currency;
	/** The next Serial Number. */
	private static long nextSerialNumber = 1_000_000;
	/** The serial Number. */
	private final long serialNumber;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 *            of this coin.
	 */
	public BankNote(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
		this.serialNumber = nextSerialNumber;
		nextSerialNumber += 1;
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 *            of this coin.
	 * @param currency
	 *            of this coin.
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
		nextSerialNumber += 1;
	}

	/**
	 * return that Coin is the same value or not.
	 * 
	 * @param obj
	 *            is the coin that want to check.
	 * @return true if same , false is not same.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		BankNote object = (BankNote) obj;
		if (object.value == this.value && object.getCurrency() == this.getCurrency())
			return true;
		return false;
	}

	public long getSerial() {
		return this.serialNumber;
	}

	@Override
	public double getValue() {
		return this.value;
	}

	@Override
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * return BankNote String.
	 * 
	 * @return the value of banknote with serial number.
	 */
	public String toString() {
		return this.value + " " + this.currency + " note [" + this.serialNumber + "]";
	}

	/**
	 * compare the value of the BankNote.
	 * 
	 * @param o
	 *            is the BankNote that want to compare the value.
	 * @return -1 if o less than value , 0 if it's same , 1 if o more than
	 *         value.
	 */
	@Override
	public int compareTo(BankNote o) {
		if (o == null)
			return -1;
		return (int) Math.signum(this.value - o.value);
	}
}