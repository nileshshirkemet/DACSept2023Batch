namespace Taxation;

public readonly struct Supervisor : ITaxPayer
{
    public int Subordinates { get; init; }

    public decimal AnnualIncome()
    {
        return 500000 + 3000 * Subordinates;
    }
}