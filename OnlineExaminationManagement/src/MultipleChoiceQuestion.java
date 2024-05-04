class MultipleChoiceQuestion {
    private String question;
    private String[] options;
    private int correctOption;

    public MultipleChoiceQuestion(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    // Method to display question and options
    public void displayQuestion() {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    // Method to check answer
    public boolean checkAnswer(int selectedOption) {
        return selectedOption == correctOption;
    }
}
