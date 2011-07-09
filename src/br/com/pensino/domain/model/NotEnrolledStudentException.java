package br.com.pensino.domain.model;

/**
 *
 * @author emiliowl
 */
public class NotEnrolledStudentException extends RuntimeException {
    public NotEnrolledStudentException() {
        super("Aluno não matriculado nesta matéria.");
    }
}
