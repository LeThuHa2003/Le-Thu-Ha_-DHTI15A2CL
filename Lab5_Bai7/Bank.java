/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5_Bai7;

/**
 *
 * @author Asus
 */
public class Bank {
    double [] accounts;
    public Bank(int n, double gtriBanDau)
    {
        accounts = new double[n];
        for (int i = 0; i < accounts.length; i++)
        {
            accounts[i] = gtriBanDau;
        }
    }
    public int size()
    {
        return accounts.length;
    }
    
    public synchronized double getTotal()
    {
        double total = 0;
        for (int i = 0; i < accounts.length; i++)
        {
            total += accounts[i];
        }
        return total;
    }
    public synchronized void transfer(int from, int to, double amount)
    {
        try
        {
            while(accounts[from] < amount)
            {
                System.out.println(Thread.currentThread().getName() + " đợi đủ tiền" + "\n");
                wait();
                System.out.println(Thread.currentThread().getName() + " tiếp tục giao dịch");
            }
            accounts[from] -= amount;
            accounts[to] += amount;
            System.out.println("Chuyển " + amount + " từ account " + from + " sang account " + to);
            System.out.println("Tổng tiền của các account: " + getTotal() + "\n");
            notifyAll();
        }
        catch(InterruptedException ex)
        {
            //System.out.println("Giao dịch của bạn bị gián đoạn!" + ex);
            InterruptedException("Giao dịch bị gián đoạn!");
        }
    }

    private void InterruptedException(String giao_dịch_bị_gián_đoạn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
