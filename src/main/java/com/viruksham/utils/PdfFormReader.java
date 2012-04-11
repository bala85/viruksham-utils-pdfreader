/**
 * 
 */
package com.viruksham.utils;

import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

/**
 * @author star
 * 
 */
public class PdfFormReader {

	public static void main(String[] args) throws IOException,
			COSVisitorException {
		PDDocument document;
		document = PDDocument.load(args[0]);
		if (document.isEncrypted()) {
			System.err
					.println("Error: Encrypted documents are not supported for this example.");
			System.exit(1);
		}

		PDDocumentCatalog catalog = document.getDocumentCatalog();

		PDAcroForm form = catalog.getAcroForm();
		List<PDField> listOfFields = form.getFields();
		for (PDField pdField : listOfFields) {
			String fieldName = pdField.getFullyQualifiedName();
			String fieldType = pdField.getFieldType();
			String fieldValue = pdField.getValue();
			System.out.println("Name: "+fieldName+" Type: "+fieldType+" Value: "+fieldValue);
		}
	}
}
