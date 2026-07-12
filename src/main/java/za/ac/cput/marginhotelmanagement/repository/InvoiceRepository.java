package za.ac.cput.marginhotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.marginhotelmanagement.domain.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
