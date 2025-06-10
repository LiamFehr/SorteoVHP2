package Liam.SorteoVHP2;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Mapea la raíz "/" y redirige al formulario
    @GetMapping("/")
    public String inicio() {
        return "redirect:/formulario";
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "formulario";
    }
    @PostMapping("/clientes")
    public String guardarCliente(@ModelAttribute("cliente") @Valid Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            return "formulario";
        }
        if (clienteRepository.existsByDni(cliente.getDni())) {
            result.rejectValue("dni", "error.cliente", "El DNI ya está registrado");
            return "formulario";
        }
        clienteRepository.save(cliente);
        return "redirect:/formulario?exito=true"; // 👈 Redirige al formulario con éxito
    }
}
