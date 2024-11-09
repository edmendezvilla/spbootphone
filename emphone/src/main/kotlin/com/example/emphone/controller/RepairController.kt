import com.example.emphone.dto.RepairDto
import com.example.emphone.response.ErrorResponse
import com.example.emphone.response.SuccessResponse
import com.example.emphone.service.RepairService  // Importar el servicio adecuado
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/repairs")
class RepairController {

    @Autowired
    lateinit var repairService: RepairService  // Inyectar el servicio correctamente

    @PostMapping
    fun create(@RequestBody @Valid repairDto: RepairDto): Any {
        return try {
            val repair = repairService.save(repairDto)  // Llamar al servicio para guardar la reparación
            SuccessResponse(data = repair)
        } catch (e: Exception) {
            ErrorResponse(message = "Error al crear la reparación", code = 500)
        }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid repairDto: RepairDto): Any {
        return try {
            val repair = repairService.updateRepair(id, repairDto)  // Llamar al servicio para actualizar la reparación
            SuccessResponse(data = repair)
        } catch (e: Exception) {
            ErrorResponse(message = "Error al actualizar la reparación", code = 500)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): Any {
        return try {
            repairService.deleteRepair(id)  // Llamar al servicio para eliminar la reparación
            SuccessResponse(data = "Reparación eliminada correctamente")
        } catch (e: Exception) {
            ErrorResponse(message = "Error al eliminar la reparación", code = 500)
        }
    }

    @GetMapping("/{id}")
    fun getRepairById(@PathVariable id: Long): Any {
        return try {
            val repair = repairService.getRepairById(id)  // Llamar al servicio para obtener la reparación por ID
            repair?.let {
                SuccessResponse(data = repair)
            } ?: ErrorResponse(message = "Reparación no encontrada", code = 404)
        } catch (e: Exception) {
            ErrorResponse(message = "Error al obtener la reparación", code = 500)
        }
    }
}

