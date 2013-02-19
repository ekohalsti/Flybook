package hlrv.flybook;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

/**
 * This class provides the form for LoginView
 * 
 * The password field is a normal textfield. How do we set it secret?
 * 
 * @author Esa Halsti
 */
public class LoginForm extends CustomComponent {

    /*
     * A set for individual properties which are fed to the propertyitemset to
     * form a datasource which in turn will feed the data to an sqlcontainer
     * which updates the underlying database. Do it the Vaadin way!
     */
    private final PropertysetItem item;

    /*
     * Layout for the form and the composition root which is required by
     * CustomComponent
     */
    private final VerticalLayout layout;

    /*
     * We need to define style for the button. That's why this is not an
     * anonymous class.
     */
    private final Button register;

    /*
     * The form for login information. This form is used to pass information to
     * the database. It's data is updated using the form.commit()-method
     */
    private final FieldGroup form;

    /**
     * The Constructor
     */
    public LoginForm() {

        /*
         * Instantiation
         */
        item = new PropertysetItem();
        layout = new VerticalLayout();
        form = new FieldGroup();
        register = new Button("Register");

        /*
         * Set properties as data source
         */
        form.setItemDataSource(item);

        /*
         * Set properties
         */
        item.addItemProperty("login", new ObjectProperty<String>("login"));
        item.addItemProperty("password", new ObjectProperty<String>("password"));

        /*
         * Set layout properties
         */
        layout.setMargin(true);
        layout.setSpacing(true);
        layout.setSizeFull();

        /*
         * Button styling
         */
        register.setStyleName("link");

        /*
         * set properties as textfield components to the UI
         */
        for (Object propertyID : form.getUnboundPropertyIds()) {

            /**
             * Add a component to the form
             */
            layout.addComponent(form.buildAndBind(propertyID));
        }

        /*
         * Add buttons to the layout and implement anonymous listeners:
         * register, submit
         */
        layout.addComponent(register);
        layout.addComponent(new Button("Submit", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {

                /*
                 * Implement the authentication method here in conjunction with
                 * the form.commit.
                 */
                try {
                    form.commit();
                } catch (CommitException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }));

        /*
         * Implement listener for the register button to open modal window for
         * RegisterView.
         */
        register.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {

                /*
                 * !!! THIS IS A HACK! DO THIS PROPERLY!
                 */
                FlybookUI.getCurrent().addWindow(new RegisterView());
            }

        });

        /**
         * Remember to setCompositionRoot. Required by CustomComponent
         */
        this.setCompositionRoot(layout);
    }
}