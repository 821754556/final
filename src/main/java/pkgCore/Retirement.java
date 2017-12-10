package pkgCore;


public class Retirement {

	private int iYearsToWork;
	private double dAnnualReturnWorking;
	private int iYearsRetired;
	private double dAnnualReturnRetired;
	private double dRequiredIncome;
	private double dMonthlySSI;
	
	
	public double AmountToSave()
	{
		double RAnnualReturnWorking = dAnnualReturnWorking / 12;
		double DMonthsToWork = iYearsToWork * 12;
		double ReturnVal = 0;
		if (RAnnualReturnWorking == 0) {
			ReturnVal = TotalAmountSaved()/DMonthsToWork;
	    }else {
	    	ReturnVal = TotalAmountSaved()* RAnnualReturnWorking
	                  /(Math.pow(1+RAnnualReturnWorking, DMonthsToWork)-1);
		}
		return ReturnVal;
	}
	
	public int getiYearsToWork() {
		return iYearsToWork;
	}

	public void setiYearsToWork(int iYearsToWork) {
		this.iYearsToWork = iYearsToWork;
	}

	public double getdAnnualReturnWorking() {
		return dAnnualReturnWorking;
	}

	public void setdAnnualReturnWorking(double dAnnualReturnWorking) {
		this.dAnnualReturnWorking = dAnnualReturnWorking;
	}

	public int getiYearsRetired() {
		return iYearsRetired;
	}

	public void setiYearsRetired(int iYearsRetired) {
		this.iYearsRetired = iYearsRetired;
	}

	public double getdAnnualReturnRetired() {
		return dAnnualReturnRetired;
	}

	public void setdAnnualReturnRetired(double dAnnualReturnRetired) {
		this.dAnnualReturnRetired = dAnnualReturnRetired;
	}

	public double getdRequiredIncome() {
		return dRequiredIncome;
	}

	public void setdRequiredIncome(double dRequiredIncome) {
		this.dRequiredIncome = dRequiredIncome;
	}

	public double getdMonthlySSI() {
		return dMonthlySSI;
	}

	public void setdMonthlySSI(double dMonthlySSI) {
		this.dMonthlySSI = dMonthlySSI;
	}

	public Retirement(int iYearsToWork, double dAnnualReturnWorking, int iYearsRetired, double dAnnualReturnRetired,
			double dRequiredIncome, double dMonthlySSI) {
		super();
		this.iYearsToWork = iYearsToWork;
		this.dAnnualReturnWorking = dAnnualReturnWorking;
		this.iYearsRetired = iYearsRetired;
		this.dAnnualReturnRetired = dAnnualReturnRetired;
		this.dRequiredIncome = dRequiredIncome;
		this.dMonthlySSI = dMonthlySSI;
	}

	public double TotalAmountSaved()
	{
		double RAnnaulReturnRetired = dAnnualReturnRetired / 12;
		double ReturnVal = 0;
		int DMonthsRetired = iYearsRetired*12;
		if (RAnnaulReturnRetired == 0) {
			ReturnVal = iYearsRetired*(dRequiredIncome - dMonthlySSI);
		}else {
			ReturnVal = (dRequiredIncome-dMonthlySSI)*((Math.pow(1+RAnnaulReturnRetired,DMonthsRetired)-1)/RAnnaulReturnRetired)
					/Math.pow(1+RAnnaulReturnRetired, DMonthsRetired);
		}
		return ReturnVal;
	}
}
