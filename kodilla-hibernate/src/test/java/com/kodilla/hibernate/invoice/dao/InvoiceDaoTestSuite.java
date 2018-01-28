package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave(){
        //Given
        Invoice invoice1 = new Invoice("0001/2018");

        Item itemNails = new Item(new Product("nails"), new BigDecimal(0.20), 200);
        invoice1.getItems().add(itemNails);
        itemNails.setInvoice(invoice1);

        Item itemScrews = new Item(new Product("screws"), new BigDecimal(0.30), 300);
        invoice1.getItems().add(itemScrews);
        itemScrews.setInvoice(invoice1);

        Invoice invoice2 = new Invoice("0002/2018");

        Item itemHammers = new Item(new Product("hammer"), new BigDecimal(03.0), 10);
        invoice2.getItems().add(itemHammers);
        itemHammers.setInvoice(invoice2);

        Item itemAxes = new Item(new Product("axe"), new BigDecimal(5.0), 10);
        invoice2.getItems().add(itemAxes);
        itemAxes.setInvoice(invoice2);

        //When
        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);

        int invoiceId = invoice1.getId();
        long invoiceQuantity = invoiceDao.count();

        //Then
        Assert.assertNotEquals(0, invoiceId);
        Assert.assertEquals(2, invoiceQuantity);

        //CleanUp
        try {
            invoiceDao.delete(invoice1);
            invoiceDao.delete(invoice2);
        } catch (Exception e) {
            //do nothing
        }
    }
}
