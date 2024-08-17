package com.example.demo.bootstrap;

import java.util.*;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.repositories.*;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        /* Disregard this block of comments
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */

        long partCount = this.partRepository.count();
        long productCount = this.productRepository.count();
        int duplicateChecker = 0;

        //for (int duplicateChecker = 0; duplicateChecker < 2; duplicateChecker++) {
        if (partCount == 0 && productCount == 0) {

            if (duplicateChecker == 1) {
                OutsourcedPart multiPack = new OutsourcedPart();
                multiPack.setCompanyName("Andy PC");
                multiPack.setName("Multi-Pack");
                multiPack.setInv(3);
                multiPack.setMinimumInventory(0);
                multiPack.setMaximumInventory(50);
                multiPack.setPrice(159.98);
                multiPack.setId(7675029);
                outsourcedPartRepository.save(multiPack);
                OutsourcedPart thePart = null;
                List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
                for (OutsourcedPart part : outsourcedParts) {
                    if (part.getName().equals("Multi-Pack")) thePart = part;
                }
            }

            OutsourcedPart cpu = new OutsourcedPart();
            cpu.setCompanyName("Andy PC");
            cpu.setName("CPU");
            cpu.setInv(5);
            cpu.setMinimumInventory(0);
            cpu.setMaximumInventory(50);
            cpu.setPrice(299.99);
            cpu.setId(6438943);
            outsourcedPartRepository.save(cpu);
            OutsourcedPart thePart = null;
            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("CPU")) thePart = part;
            }

            System.out.println(thePart.getCompanyName());

            OutsourcedPart gpu = new OutsourcedPart();
            gpu.setCompanyName("Andy PC");
            gpu.setName("GPU");
            gpu.setInv(3);
            gpu.setMinimumInventory(0);
            gpu.setMaximumInventory(50);
            gpu.setPrice(549.99);
            gpu.setId(6561517);
            outsourcedPartRepository.save(gpu);
            //OutsourcedPart thePart=null;
            //List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("GPU")) thePart = part;
            }

            System.out.println(thePart.getCompanyName());

            OutsourcedPart ram = new OutsourcedPart();
            ram.setCompanyName("Andy PC");
            ram.setName("RAM");
            ram.setInv(6);
            ram.setMinimumInventory(0);
            ram.setMaximumInventory(50);
            ram.setPrice(69.99);
            ram.setId(6448611);
            outsourcedPartRepository.save(ram);
            //OutsourcedPart thePart=null;
            //List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("RAM")) thePart = part;
            }

            System.out.println(thePart.getCompanyName());

            OutsourcedPart psu = new OutsourcedPart();
            psu.setCompanyName("Andy PC");
            psu.setName("PSU");
            psu.setInv(15);
            psu.setMinimumInventory(0);
            psu.setMaximumInventory(50);
            psu.setPrice(69.99);
            psu.setId(6448611);
            outsourcedPartRepository.save(psu);
            //OutsourcedPart thePart=null;
            //List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("PSU")) thePart = part;
            }

            System.out.println(thePart.getCompanyName());

            OutsourcedPart ssd = new OutsourcedPart();
            ssd.setCompanyName("Andy PC");
            ssd.setName("SSD");
            ssd.setInv(25);
            ssd.setMinimumInventory(0);
            ssd.setMaximumInventory(50);
            ssd.setPrice(89.99);
            ssd.setId(6459241);
            outsourcedPartRepository.save(ssd);
            //OutsourcedPart thePart=null;
            //List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("SSD")) thePart = part;
            }

            System.out.println(thePart.getCompanyName());

            //List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                System.out.println(part.getName() + " " + part.getCompanyName());
            }

            Product workhorsePC = new Product("Workhorse PC", 599.99, 4);
            Product gamingPC = new Product("Gaming PC", 799.99, 7);
            Product laptop = new Product("Laptop", 449.99, 2);
            Product allInOne = new Product("All-in-one", 299.99, 3);
            Product mac = new Product("Mac", 799.99, 5);
            productRepository.save(workhorsePC);
            productRepository.save(gamingPC);
            productRepository.save(laptop);
            productRepository.save(allInOne);
            productRepository.save(mac);

            duplicateChecker = 1;

        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products" + productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts" + partRepository.count());
        System.out.println(partRepository.findAll());
    }
}

