package designpattern.structural;

public abstract class ColumnDecorator implements Report {

    private Report decoratedReport;

    public ColumnDecorator(Report report){
        this.decoratedReport = report;
    }

    public String getFirstColumnData() {
        return decoratedReport.getFirstColumnData();
    }

    @Override
    public Object[][] getReportData(String reportId) {
        return decoratedReport.getReportData(reportId);
    }
}
