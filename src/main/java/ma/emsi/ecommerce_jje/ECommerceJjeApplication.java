package ma.emsi.ecommerce_jje;

import ma.emsi.ecommerce_jje.entites.Product;
import ma.emsi.ecommerce_jje.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
// j'ai implemente interface CommandLineRunner pour execute mes lignes avec le demarage de mon application et je redefiner la methode run

public class ECommerceJjeApplication implements CommandLineRunner {
    @Autowired // pour fair l'injection des dependences pour demande a sprint inject moi des objets de type ProductRepository
    private ProductRepository productRepository;

    public static void main(String[] args) {


        SpringApplication.run(ECommerceJjeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"Desktop",3422,4)) ;
        productRepository.save(new Product(null,"SmartTv",5400,2));
        productRepository.save(new Product(null,"Laptop",7499,5));
        productRepository.save(new Product(null,"Smartphone",2300,6));
        productRepository.save(new Product(null,"Macbook",8400,3));
        List<Product> products = productRepository.findAll();
        products.forEach(p->{
            System.out.printf(p.toString()+"\n");


        });
        
        Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.println("---------------------------");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("----------------------------");
        System.out.println("**********************************");
        List<Product> productList1 = productRepository.findByNameContains("S");
        productList1.forEach(p->{
            System.out.println(p);
        });
        System.out.println("---------------------------------");
        List<Product> productList2 = productRepository.search("%S%");
        productList2.forEach(p->{
            System.out.println(p);
        });


        System.out.println("---------------------------------");
        List<Product> productList3 = productRepository.findByPriceGreaterThan(3000);
        productList3.forEach(p->{
            System.out.println(p);
        });

        System.out.println("---------------------------------");
        List<Product> productList4 = productRepository.searchByPrice(3000);
        productList4.forEach(p->{
            System.out.println(p);
        });



    }
}
