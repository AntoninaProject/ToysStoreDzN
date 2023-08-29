package toysstore;

import java.util.Queue;
import toysstore.lototron.Lot;
import toysstore.lototron.Lototron;
import java.util.LinkedList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static String file_name = "Raffl_result";
    private static Queue<Lot> prizes = new LinkedList<Lot>();
    private static Lototron lototron = new Lototron();
    public static void main(String[] args) {
        String menu = "Комманды:\n" +
                      "0 - показать команды\n" +
                      "1 - добавить новый лот в лототрон\n" +
                      "2 - изменить количество игрушек в лоте\n" +
                      "3 - показать что в лототроне\n" +
                      "4 - начать розыгрыш!\n" +
                      "5 - достать игрушку из лототрона и поместить в выдачу\n" +
                      "6 - записать игрушку в файл из выдачи\n" +
                      "7 - завершить программу!\n";

        System.out.print("Розыгрыш игрушек!\n");
        System.out.print(menu);
        boolean run = true;
        Lot lot;
        String command;
        while (run) {
            command = input("Введите команду: ");
            switch (command) {
                case "0":
                    System.out.print(menu);
                    break;
                case "1":
                    lototron.addLot();
                    break;
                case "2":
                    lototron.changeAmtForLot();
                    break;
                case "3":
                    System.out.print(lototron);
                    break;
                case "4":
                    lototron.startRaffl();
                    break;
                case "5":
                    lot = lototron.getPrize();
                    if (lot != null) {
                        prizes.add(lot);
                    }
                    break;
                case "6":
                    writePrize();
                    break;
                case "7":
                    run = false;
                    break;
                default:
                    System.out.print("Нет такой команды! Введите 0 для просмотра всех команд!\n");
                    break;
            }
        }
    }

    public static void writePrize() {
        if (prizes.size() > 0) {
            Lot lot = prizes.poll();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file_name, true));
                writer.write(lot.getItem().toString() + "\n");
                writer.close();
                System.out.print("Игрушка успешно записана в файл\n");
            }
            catch (IOException e) {
                System.out.println("Ошибка при записи файла: " + e.getMessage());
            }
        }
        else {
            System.out.print("В выдаче нет игрушек!\n");
        }
    }

    public static String input(String message) {
        System.out.print(message);
        return System.console().readLine().strip();
    }
}
