package com.dbs.web.services;

 

import java.time.LocalDate;
import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.dbs.web.beans.BuyOrder;
import com.dbs.web.beans.SellOrder;
import com.dbs.web.repository.BuyOrderRepository;
import com.dbs.web.repository.SellOrderRepository;

 

@Service
public class SellOrderService {
    
    @Autowired
    private SellOrderRepository sellRepo;
    
    @Autowired
    private BuyOrderService buyservice;
    
    @Autowired
    private BuyOrderRepository buyRepo;

 

    public List<SellOrder> getSellOrderByOrderDate() {
        try { 
            List<SellOrder> sellorder =this.sellRepo.findByOrderDate().get();
    return sellorder; 
    }
        catch(IllegalArgumentException e ) { return null; } 
    }
    
    public boolean insertSellOrder(SellOrder so)    {
        if(this.sellRepo.findById(so.getSellid()).isPresent())
            return false;
        try {
        	so.setOrderdate(LocalDate.now());
            this.sellRepo.save(so);
            sellmatch(so);
        }catch(IllegalArgumentException e )
        {
            return false;
        }
        return true;
    }
public void sellmatch(SellOrder so) {
        
        List<BuyOrder> buyod=this.buyservice.getBuyOrderByOrderDate();
        
        for(BuyOrder bo:buyod) {
            if(so.getInstrumentid().getInstrumentid().equals(bo.getInstrumentid().getInstrumentid())&&so.getPrice()==bo.getPrice()) {
                if(so.getRemainingquantity()==bo.getRemainingquantity()) {
                    int tempqunatity=bo.getRemainingquantity()-so.getRemainingquantity();
                    bo.setRemainingquantity(tempqunatity);
                    so.setRemainingquantity(tempqunatity);
                    bo.setStatus("Completed");
                    so.setStatus("Completed");
                }
                else if(so.getRemainingquantity()>bo.getRemainingquantity()) {
                    int tempqunatity=so.getRemainingquantity()-bo.getRemainingquantity();
                    so.setRemainingquantity(tempqunatity);
                    bo.setRemainingquantity(0);
                    bo.setStatus("Completed");
                    so.setStatus("Partially Completed");
    
                }
                else {
                    int tempqunatity=bo.getRemainingquantity()-so.getRemainingquantity();
                    bo.setRemainingquantity(tempqunatity);
                    so.setRemainingquantity(0);
                    bo.setStatus("Partially Completed");
                    so.setStatus("Completed");
                    
                }
             this.buyRepo.save(bo);
             this.sellRepo.save(so);
             //break;    
            }    
        }
        
    }
}