package weblab;

import java.util.*;

class Exam {

    private PriorityQueue<ExamQuestion> q;
    /**
     * Constructor.
     *
     * @param questions - the questions that are part of this exam
     */
    public Exam(ExamQuestion[] questions) {
        q = new PriorityQueue();
        for (ExamQuestion e : questions) q.add(e);
    }

    /**
     * Returns the next question that should be answered on this exam,
     * the values of the returned exam questions should be in descending order (i.e. questions with high value should be returned first)
     *
     * @return the next question that should be answered on this exam.
     */
    public ExamQuestion getNext() {
        return q.poll();
    }
}
