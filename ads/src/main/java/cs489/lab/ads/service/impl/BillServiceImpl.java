package cs489.lab.ads.service.impl;

import cs489.lab.ads.model.Bill;
import cs489.lab.ads.repository.BillRepository;
import cs489.lab.ads.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;
    @Override
    public Bill createBill(Bill bill) {
        return billRepository.save(bill);
    }
}
