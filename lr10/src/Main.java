import exceptions.OkladException;
import model.ContractEmployee;
import model.SalariedEmployee;

public class Main {
	public static void main(String[] args) {
		System.out.println("Демонстрация обработки исключений\n");

		// a) Проверка расчета зарплаты и обработки PremiyaException и других Exception
		try {
			SalariedEmployee seOk = new SalariedEmployee("Иван", 50000, 10000);
			System.out.println("Зарплата (штатный, корректные данные): " + seOk.computeSalary());

			SalariedEmployee seBadBonus = new SalariedEmployee("Петр", 40000, -5000);
			System.out.println("Зарплата (штатный, отрицательная премия): " + seBadBonus.computeSalary());

			ContractEmployee ceOk = new ContractEmployee("Анна", 20000, 800, 20);
			System.out.println("Зарплата (контракт, корректные данные): " + ceOk.computeSalary());

			ContractEmployee ceBadHours = new ContractEmployee("Сергей", 20000, 800, -10);
			System.out.println("Зарплата (контракт, отрицательные часы): " + ceBadHours.computeSalary());
		} catch (OkladException e) {
			// сюда попадем если конструктор выбросит OkladException
			System.out.println("Ошибка при создании сотрудника: " + e.getMessage());
		}

		System.out.println("\nБлок б) демонстрация OkladException при создании сотрудника\n");

		try {
			// Фабричный метод обрабатывает и перекидывает исключение дальше
			createSalariedEmployee("Николай", -30000, 5000);
		} catch (OkladException e) {
			System.out.println("main поймал повторно брошенное исключение: " + e.getMessage());
		}
	}

	// Фабрика: обрабатывает OkladException, печатает требуемое сообщение и повторно бросает
	private static SalariedEmployee createSalariedEmployee(String name, double oklad, double bonus) throws OkladException {
		try {
			return new SalariedEmployee(name, oklad, bonus);
		} catch (OkladException e) {
			System.out.println("Невозможно создать сотрудника – указан отрицательный оклад: " + e.getAmount());
			throw e; // повторно создаем/бросаем исключение
		}
	}
}


