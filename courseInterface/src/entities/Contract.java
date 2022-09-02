package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

    private Integer number;
    private Date date;
    private Double totalValue;

    private List<Installment> installments = new ArrayList<>();

    public Contract(int number, Date date, double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    //apenas o get do Arry para que o mesmo n seja substituido pelo metodo set
    public List<Installment> getInstallments() {
        return installments;
    }

    //tbm nao pode esquecer dos metodos para adicionar e remover itens na lista;
    public void addInstallment(Installment installment) {
        installments.add(installment);
    }

    public void removeInstallment(Installment installment) {
        installments.remove(installment);
    }

}
