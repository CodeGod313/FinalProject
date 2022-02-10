import by.epam.finalproject.model.entity.Client;
import by.epam.finalproject.model.exception.DaoException;
import by.epam.finalproject.model.exception.WrongParameterException;
import by.epam.finalproject.model.service.RegistrationService;
import by.epam.finalproject.model.service.impl.RegistrationServiceImpl;

public class Testik {
    public static void main(String[] args) {
        RegistrationService registrationService = new RegistrationServiceImpl();
        Client client = new Client("Popa", "Kaka", "lol@lol.lol", "alexa098", "MC", "3333333");
        try {
            registrationService.registerClient(client);
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (WrongParameterException e) {
            e.printStackTrace();
        }
    }
}