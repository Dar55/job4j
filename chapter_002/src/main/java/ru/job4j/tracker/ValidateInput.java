package ru.job4j.tracker;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }
    public int ask(String question, int[] range) {
        boolean invalid = true;
        boolean exist = false;
        int value = -1;
        int key;
        do {
            try {
                value = this.input.ask(question, range);
                key = Integer.valueOf(value);
                for (int val : range) {
                    if (val == key) {
                        exist = true;
                        break;
                    }
                }
                    if (!exist) {
                        throw new MenuOutException("Out of menu range.");
                    }
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate again.");
            }
        }
            while (invalid);
            return value;
        }
    }
