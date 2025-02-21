package com.xlm.cucumberdemo.pdfreporting;

import com.aventstack.extentreports.Status;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.util.List;

import static com.xlm.cucumberdemo.utility.Utility.setCellFonts;
import static com.xlm.cucumberdemo.utility.Utility.setFont;

public class PDFTestReportModel {

    private String testName;
    private Status testResult;
    private List<String> testDescriptions;

    public PDFTestReportModel(String testName) {
        this.testName = testName;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Status getTestResult() {
        return testResult;
    }

    public void setTestResult(Status testResult) {
        this.testResult = testResult;
    }

    public List<String> getTestDescriptions() {
        return testDescriptions;
    }

    public void setTestDescriptions(List testDescriptions) {
        this.testDescriptions = testDescriptions;
    }

    public PdfPTable setTestResultTable() {
        PdfPTable table = new PdfPTable(3);

        table.addCell(setCellFonts(setFont("TEST NAME", 14, BaseColor.BLACK), Element.ALIGN_CENTER, Element.ALIGN_MIDDLE));
        table.addCell(setCellFonts(setFont("STEP DESCRIPTION", 14, BaseColor.BLACK), Element.ALIGN_CENTER, Element.ALIGN_MIDDLE));
        table.addCell(setCellFonts(setFont("TEST RESULT", 14, BaseColor.BLACK), Element.ALIGN_CENTER, Element.ALIGN_MIDDLE));

        table.addCell(setCellFonts(setFont(testName, 12, BaseColor.BLACK), Element.ALIGN_CENTER, Element.ALIGN_MIDDLE));

        PdfPCell testDescription = new PdfPCell();
        for (String Description : testDescriptions) {
            testDescription.addElement(setFont(Description, 12, BaseColor.BLACK));
        }

        testDescription.setVerticalAlignment(Element.ALIGN_MIDDLE);
        testDescription.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(testDescription);

        if (testResult.toString().equalsIgnoreCase("pass")) {
            table.addCell(setCellFonts(setFont(testResult.toString().toUpperCase(), 12, BaseColor.GREEN), Element.ALIGN_CENTER, Element.ALIGN_MIDDLE));
        } else if (testResult.toString().equalsIgnoreCase("fail")) {
            table.addCell(setCellFonts(setFont(testResult.toString().toUpperCase(), 12, BaseColor.RED), Element.ALIGN_CENTER, Element.ALIGN_MIDDLE));
        } else {
            table.addCell(setCellFonts(setFont(testResult.toString().toUpperCase(), 12, BaseColor.YELLOW), Element.ALIGN_CENTER, Element.ALIGN_MIDDLE));
        }

        return table;
    }
}
