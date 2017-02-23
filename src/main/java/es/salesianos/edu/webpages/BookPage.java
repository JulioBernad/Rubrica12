package es.salesianos.edu.webpages;

import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import es.salesianos.edu.model.Book;
import es.salesianos.edu.service.SimulacroService;

public class BookPage extends WebPage {

	@SpringBean
	SimulacroService simulacroService;

	public BookPage() {


		Form form = new Form("formInsertLogin2", new CompoundPropertyModel(new Book())) {

			@Override
			protected void onSubmit() {
				super.onSubmit();
				boolean isInserted = simulacroService.insert((Book) getModelObject());
				FeedbackMessage message;
				if(isInserted){
					message = new FeedbackMessage(this, "libro insertado", FeedbackMessage.INFO);
				} else {
					message = new FeedbackMessage(this, "no se pudo insertar", FeedbackMessage.INFO);
				}
				getFeedbackMessages().add(message);
			}

		};
		form.add(new Label("nameBookLabel", getString("book.name")));
		form.add(new Label("isbnLabel", getString("isbn")));
		form.add(new Label("nameAuthorLabel", getString("author.name")));
		form.add(new RequiredTextField("nameBook"));
		form.add(new RequiredTextField("isbn"));
		form.add(new RequiredTextField("nameAuthor"));
		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMessage");
		feedbackPanel.setOutputMarkupId(true);
		add(feedbackPanel);

		add(form);

	}

}
