package no.martinsolaas.origodemo.ui;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@ParentLayout(MainLayout.class)
public class ErrorView extends InternalServerError {

    @Override
    public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<Exception> parameter) {

        Div wrapper = new Div();
        Element header = new H1("An error occurred :0(").getElement();
        Element body = new Paragraph(ExceptionUtils.getRootCauseMessage(parameter.getException())).getElement();
        wrapper.getElement().appendChild(header);
        wrapper.getElement().appendChild(body);

        getElement().appendChild(wrapper.getElement());

        log.error(ExceptionUtils.getStackTrace(parameter.getException()));
        return HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
    }
}
