package pkgEmpty;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Retirement;

public class TestRetirement {

	@Test
	public void test() {
		int IYearsToWork = 41;
		double DAnnualReturnWorking = 0.09;
		int IYearsRetired = 25;
		double DAnnualReturnRetired = 0.03;
		double DRequiredIncome = 11000;
		double DMonthlySSI = 3221;
		
		Retirement Retirement = new Retirement(IYearsToWork, DAnnualReturnWorking, IYearsRetired, DAnnualReturnRetired, DRequiredIncome, DMonthlySSI);
		
		assertEquals(1640407.93053, Retirement.TotalAmountSaved(), 0.01);
		assertEquals(319.5827, Retirement.AmountToSave(), 0.01);
		 
	}

}
