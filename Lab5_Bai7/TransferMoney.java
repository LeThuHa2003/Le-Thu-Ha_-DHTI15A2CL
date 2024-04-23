/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5_Bai7;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class TransferMoney implements Runnable{
    Bank bank;
    int fromAcc;
    double maxAmount;
    int delay = 1000;

    public TransferMoney(Bank bank, int fromAcc, double maxAmount) {
        this.bank = bank;
        this.fromAcc = fromAcc;
        this.maxAmount = maxAmount;
    }
    
    @Override
    public void run()
    {
        Random rd = new Random();
        int toAcc = 0;
        double amount = 0;
        try 
        {
            while(true)
            {
                do 
                {
                    toAcc = rd.nextInt(bank.size());
                }while(toAcc == fromAcc);
                amount = rd.nextInt((int)maxAmount);
                bank.transfer(fromAcc, toAcc, amount);
                Thread.sleep(rd.nextInt(delay));
            }
        } 
        catch (InterruptedException ex) {
            InterruptedException("Giao dịch chuyển tiền từ account " + fromAcc + " sang account " + toAcc + " bị gián đoạn!");
        }
    }

    private void InterruptedException(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
