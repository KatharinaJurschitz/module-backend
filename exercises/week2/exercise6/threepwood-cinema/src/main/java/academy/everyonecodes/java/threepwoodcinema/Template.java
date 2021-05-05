package academy.everyonecodes.java.threepwoodcinema;

import java.util.Objects;

public class Template {
    private String name;
    private String keyword;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Template template = (Template) o;
        return Objects.equals(name, template.name) && Objects.equals(keyword, template.keyword) && Objects.equals(message, template.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, keyword, message);
    }
}
