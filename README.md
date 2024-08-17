<strong> Andy Ng <br>
D287 - Java Frameworks <br> 
</strong>

<strong>
<br>
<br>
C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
</strong>

<pre>

    CHANGE - mainscreen.html
        Line 14 - &lt title &gt My Bicycle Shop &lt title &gt
        TO
        Line 14 - &lt title &gt Andy PC &lt /title &gt
        
        Line 19 - &lt h1 &gt Shop &lt /h1 &gt
        TO
        Line 19 - &lt h1 &gt Computer &lt /h1 &gt
</pre>

<strong>
<br>
<br>
D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
</strong>

<pre>

    CREATE - about.html

        &lt !DOCTYPE html &gt  
        &lt html lang="en" &gt  
        &lt head &gt  
            &lt meta charset="UTF-8" &gt  
            &lt title &gt  About Andy PC&lt /title &gt  
        &lt /head &gt  
        &lt body &gt  
        
            &lt p &gt  
            Andy PC has worked intimately with brands such as Intel, NVIDIA, AMD, Microsoft, Western Digital, Asus, Bethesda, MLG, and many more. Superior performance, reliability, cutting edge technology, 
            and timely production make iBUYPOWER the authority in PC gaming.
        
            &lt /p &gt  
        
            &lt a href="http://localhost:8080/" &gt  Andy PC&lt /a &gt  
        &lt /body &gt  
        &lt /html &gt  

    INSERT - mainscreen.html
    
        Line 94 - &lt a th:href="@{about}" &gt Andy PC's About Page &lt /a &gt

    INSERT - MainScreenControllerr, LINES 57-61

        @RequestMapping("/about")
        public String about() {
            return "about"; // about.html page reference
        }

</pre>

<strong>
<br>
<br>
E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part

</strong>

<pre>

    INSERT - BootStrapData.java, LINES 71-162

        // Clearing repositories for multiple test runs
        // partRepository.deleteAll();
        // productRepository.deleteAll();
        // outsourcedPartRepository.deleteAll();

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

</pre>

<strong>
<br>
<br>
F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:

•   The “Buy Now” button must be next to the buttons that update and delete products.

•   The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.

•   Display a message that indicates the success or failure of a purchase.

</strong>

<pre>

    CREATE - confirmationbuyproduct.html

        &lt !DOCTYPE html &gt 
        &lt html lang="en" &gt 
        &lt head &gt 
            &lt meta charset="UTF-8" &gt 
            &lt title &gt Product Purchase Confirmation &lt /title &gt 
        &lt /head &gt 
        &lt body &gt 
        &lt h1 &gt Your product has been purchased. &lt /h1 &gt 
        
        &lt a href="http://localhost:8080/" &gt Link to Main Screen &lt /a &gt 
        &lt /body &gt 
        &lt /html &gt 

    CREATE - failedpurchase.html

         &lt !DOCTYPE html &gt 
         &lt html lang="en" &gt 
         &lt head &gt 
             &lt meta charset="UTF-8" &gt 
             &lt title &gt Order Failed &lt /title &gt 
         &lt /head &gt 
         &lt body &gt 
         &lt h1 &gt ORDER FAILED &lt /h1 &gt 
        
         &lt a href="http://localhost:8080/" &gt Link to Main Screen &lt /a &gt 
        
         &lt /body &gt 
         &lt /html &gt 

    INSERT - mainscreen.html, LINES 89-90

        &lt a th:href="@{/buyproduct(productID=${tempProduct.id})}" class="btn btn-primary btn-sm mb-3"
        onclick="if(!(confirm('Are you sure you want to delete this product?')))return false" &gt Buy Now &lt /a &gt 
    
    INSERT - product.java, LINES 108-118

        // Instruction F: buyProduct function to decrement inventory
        // Uses a simple test to ensure product exists before decrementing
        public boolean buyProduct() {
            if (this.inv >= 1 ) {
                this.inv--;
                return true;
            } else {
                return false;
            }
        
        }

    INSERT - AddProductController.java 167 - 183

       @GetMapping("/removepart")
    public String removePart(@RequestParam("partID") int theID, Model theModel){
        theModel.addAttribute("product", product);
      //  Product product1=new Product();
        product1.getParts().remove(partService.findById(theID));
        partService.findById(theID).getProducts().remove(product1);
        ProductService productService = context.getBean(ProductServiceImpl.class);
        productService.save(product1);
        partService.save(partService.findById(theID));
        theModel.addAttribute("product", product1);
        theModel.addAttribute("assparts",product1.getParts());
        List<Part>availParts=new ArrayList<>();
        for(Part p: partService.findAll()){
            if(!product1.getParts().contains(p))availParts.add(p);
        }
        theModel.addAttribute("availparts",availParts);
        return "productForm";

</pre>

<strong>
<br>
<br>
G. Modify the parts to track maximum and minimum inventory by doing the following:

•   Add additional fields to the part entity for maximum and minimum inventory.
</strong>

<pre>

    INSERT - mainscreen.html, LINES 38-39 AND LINES 48-49
        &lt th &gt Minimum &lt /th &gt 
        &lt th &gt Maximum &lt /th &gt 

        &lt td th:text="${tempPart.minimum}" &gt 1 &lt /td &gt 
        &lt td th:text="${tempPart.maximum}" &gt 1 &lt /td &gt

</pre>

<strong>
•   Modify the sample inventory to include the maximum and minimum fields.
</strong>

<pre>

    INSERT - Part.java, LINES 36-38 AND LINES 113-117
        @Min (value = 0, message = "Minimum inventory must be > 0")
        int minimum;
        int maximum;

        public void setMinimum(int minimum) { this.minimum = minimum; }
        public int getMinimum() { return this.minimum; }
         
        public void setMaximum(int maximum) { this.maximum = maximum; }
        public int getMaximum() { return this.maximum; }

    NOTE: Added default min/max (0/100 respectively) to default constructors
    for both in house and outsource parts

    INSERT - InhousePart.java AND OutsourcedPart.java, LINES 18-20
        // Adding default values for maximum and minimum; can be changed in app
        this.minimum = 0;
        this.maximum = 100;

</pre>

<strong>
•   Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
</strong> 

<pre>

    INSERT - InhousePartForm.html AND OutsourcedPartForm.html, LINES 25-35

        &lt p &gt  &lt input type="text" th:field="*{minimum}" placeholder="Minimum" class="form-control mb-4 col-4"/ &gt  &lt /p &gt 
             
        &lt p &gt  &lt input type="text" th:field="*{maximum}" placeholder="Maximum" class="form-control mb-4 col-4"/ &gt  &lt /p &gt 
             
        &lt p &gt  &lt input type="text" th:field="*{partId}" placeholder="Part ID" class="form-control mb-4 col-4"/ &gt  &lt /p &gt 
    
        &lt p &gt 
        &lt div th:if="${#fields.hasAnyErrors()}" &gt 
            &lt ul &gt  &lt li th:each="err: ${#fields.allErrors()}" th:text="${err}" &gt  &lt /li &gt  &lt /ul &gt 
        &lt /div &gt 
        &lt /p &gt 

</pre>

<strong>
•   Rename the file the persistent storage is saved to.
</strong>

<pre>

    CHANGE - application.properties
        spring.datasource.url=jdbc:h2:file:~/spring-boot-h2-db102
        TO
        spring.datasource.url=jdbc:h2:file:~/src/main/resources/spring-boot-h2-db102

</pre>

<strong>
•   Modify the code to enforce that the inventory is between or at the minimum and maximum value.
</strong>

<pre>

NOTE: This requirement is enforced from a code standpoint by a validateLimits() function that is called
by the save() function just before saving the part changes to the repository. If the value is
outside of the threshold (e.g. below the minimum or above the maximum) then inv is forcibly set
to the corresponding limit.

    INSERT - Part.java LINES 97-103
        public void validateLimits() {
            if (this.inv < this.minimum) {
                this.inv = this.minimum;
            } else if (this.inv > this.maximum ) {
                this.inv = this.maximum;
            }
        }

    INSERT - InhousePartServiceImpl.java AND OutsourcedPartServiceImpl.java, LINE 54... save()
        thePart.validateLimits();

NOTE: there are also validators in place to prevent the form from accepting a value for inventory
that is below the minimum or above the maximum, outlined in section H. 

</pre>


<strong>
<br>
<br>
H. Add validation for between or at the maximum and minimum fields. The validation must include the following:
</strong>

<pre>

    INSERT - Part.java, LINES 21-22
        @ValidPartInventory
        @ValidPartInventoryMinimum

</pre>

<strong>
•   Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
</strong>

<pre>

    CREATE - PartInventoryMinimumValidator.java

        package com.example.demo.validators;
        
        import com.example.demo.domain.Part;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.ApplicationContext;
        
        import javax.validation.ConstraintValidator;
        import javax.validation.ConstraintValidatorContext;
        
        /**
         *
         *
         *
         *
         */
        public class PartInventoryMinimumValidator implements ConstraintValidator &lt ValidPartInventoryMinimum, Part &gt {
            @Autowired
            private ApplicationContext context;
        
            public static  ApplicationContext myContext;
        
            @Override
            public void initialize(ValidPartInventoryMinimum constraintAnnotation) {
                ConstraintValidator.super.initialize(constraintAnnotation);
            }
        
            @Override
            public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
                return part.getInv() > part.getMinimum();
            }
        }

    CREATE ValidPartInventoryMinimum.java

        package com.example.demo.validators;
        
        import javax.validation.Constraint;
        import javax.validation.Payload;
        import java.lang.annotation.ElementType;
        import java.lang.annotation.Retention;
        import java.lang.annotation.RetentionPolicy;
        import java.lang.annotation.Target;
        
        /**
         *
         *
         *
         *
         */
        @Constraint(validatedBy = {PartInventoryMinimumValidator.class})
        @Target({ElementType.TYPE})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ValidPartInventoryMinimum {
            String message() default "Inventory cannot be lower than required minimum";
            Class<?> [] groups() default {};
            Class<? extends Payload> [] payload() default {};
        }

</pre>

<strong>
•   Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
</strong>

<pre>

NOTE: There isn't a validator here because the requirements of section F is that the "Buy Now" button doesn't change the 
inventory of the associated parts. 

If I were to implement this feature, I would have needed to modify the buyProduct() 
function that I created to decrement the inventory of the parts as well like so:

    public boolean buyProduct() {
        if (this.inv >= 1 ) {
            this.inv--;

            for(Part part:this.getParts()){
                if (part.getInv() >= 1) {
                    part.setInv(part.getInv() - 1);
                } else {
                    return false;
                }
            }
    }

Then, I could have modified the errorbuypart.html to include the validation error that
would have been triggered by PartInventoryMinimumValidator.

Edited OutSourcedPartsForm.html

input type="text" th:field="*{minimumInventory}" placeholder="Minimum Inventory" class="form-control mb-4 col-4"/>
th:if="${#fields.hasErrors('minimumInventory')}" th:errors="*{minimumInventory}">Inventory Error


</pre>

<strong>
•   Display error messages when adding and updating parts if the inventory is greater than the maximum.
</strong>

<pre>

    CREATE - PartInventoryValidator.java

        package com.example.demo.validators;
        
        import com.example.demo.domain.Part;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.ApplicationContext;
        
        import javax.validation.ConstraintValidator;
        import javax.validation.ConstraintValidatorContext;
        
        /**
         *
         *
         *
         *
         */
        public class PartInventoryValidator implements ConstraintValidator &lt ValidPartInventory, Part &gt {
            @Autowired
            private ApplicationContext context;
        
            public static  ApplicationContext myContext;
        
            @Override
            public void initialize(ValidPartInventory constraintAnnotation) {
                ConstraintValidator.super.initialize(constraintAnnotation);
            }
        
            @Override
            public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
                return part.getInv() <= part.getMaximum();
            }
        }

    CREATE - ValidPartInventory.java

        package com.example.demo.validators;
        
        import javax.validation.Constraint;
        import javax.validation.Payload;
        import java.lang.annotation.ElementType;
        import java.lang.annotation.Retention;
        import java.lang.annotation.RetentionPolicy;
        import java.lang.annotation.Target;
        
        /**
         *
         *
         *
         *
         */
        @Constraint(validatedBy = {PartInventoryValidator.class})
        @Target({ElementType.TYPE})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ValidPartInventory {
            String message() default "Inventory cannot exceed maximum value";
            Class<?> [] groups() default {};
            Class<? extends Payload> [] payload() default {};
        }

</pre>

<strong>
<br>
<br>
I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

</strong>

<pre>

    INSERT - PartTest.java, LINES 161-177
        @Test
        void getMinimum() {
            int minimum=5;
            partIn.setMinimum(minimum);
            assertEquals(minimum, partIn.getMinimum());
            partOut.setMinimum(minimum);
            assertEquals(minimum, partOut.getMinimum());
        }
    
        @Test
        void getMaximum() {
            int maximum=5;
            partIn.setMaximum(maximum);
            assertEquals(maximum, partIn.getMaximum());
            partOut.setMaximum(maximum);
            assertEquals(maximum, partOut.getMaximum());
        }
</pre>

<strong>
<br>
<br>
J.  Remove the class files for any unused validators in order to clean your code.
</strong>

<pre>

Remove a validator with no usages (DeletePartValidator.java)

</pre>

