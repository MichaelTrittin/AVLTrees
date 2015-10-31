package avltrees;

public enum BalanceEnum
{
	LEFT(-1), EQUAL(0), RIGHT(1), HEAVY_LEFT(-2), HEAVY_RIGHT(2);

	protected final int code;

	BalanceEnum(int code)
	{
		this.code = code;
	}

	BalanceEnum addBalance(BalanceEnum e) throws BalanceException
	{
		int balance = code + e.code;
		switch (balance) {
		case -2:
			return HEAVY_LEFT;
		case -1:
			return LEFT;
		case 0:
			return EQUAL;
		case 1:
			return RIGHT;
		case 2:
			return HEAVY_RIGHT;
		default:
			throw new BalanceException("Attempt to create balance enum with code out of range: code = " + balance);
		}

	}

}

class BalanceException extends Exception
{

	public BalanceException(String string)
	{
		super(string);
	}

}