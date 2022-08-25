package view;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.UserController;

/**
 * JPanel para selecionar grupo para a edicao.
 * 
 */
public class UserView extends JPanel implements ActionListener {
	private static final long serialVersionUID = 3378863774624440091L;
	private JList<String> fieldGroups;
	private JButton buttonSelecionar;
	private JButton buttonNewGroup;
	private JButton buttonFinalizar;
	private UserController controller;

	/**
	 * Cria o panel com uma lista com bot�o, um bot�o para cadastrar um novo grupo e
	 * um bot�o para finalizar o cadastro.
	 */
	public UserView() {

		JFrame frame = new JFrame();

		controller = new UserController(this);

		frame.setBackground(new Color(245, 245, 220));
		frame.setLayout(null);
		frame.setBounds(100, 100, 830, 522);

		JLabel labelTitulo = new JLabel("Usuarios cadastrados:");
		labelTitulo.setFont(Jstructure.FONT);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(278, 61, 254, 16);
		frame.add(labelTitulo);

		JLabel labelTitulo2 = new JLabel("Lista:");
		labelTitulo2.setFont(Jstructure.FONT);
		labelTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo2.setBounds(108, 84, 602, 16);
		frame.add(labelTitulo2);

		buttonSelecionar = new JButton("Selecionar");
		buttonSelecionar.setForeground(new Color(153, 51, 102));
		buttonSelecionar.setFont(Jstructure.FONT);
		buttonSelecionar.setBackground(Color.LIGHT_GRAY);
		buttonSelecionar.setBounds(122, 410, 117, 21);
		buttonSelecionar.addActionListener(this);
		frame.add(buttonSelecionar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(122, 110, 588, 289);
		frame.add(scrollPane);

		fieldGroups = new JList<>();
		scrollPane.setViewportView(fieldGroups);
		// fieldGroups.setModel(controller.atualizarModeloLista());
		fieldGroups.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		fieldGroups.setFont(Jstructure.FONT);
		fieldGroups.setForeground(Color.BLACK);
		fieldGroups.setBackground(new Color(245, 245, 220));

		buttonNewGroup = new JButton("Novo usuario");
		buttonNewGroup.setFont(Jstructure.FONT);
		buttonNewGroup.setForeground(Color.BLACK);
		buttonNewGroup.setBackground(SystemColor.activeCaption);
		buttonNewGroup.setBounds(122, 437, 182, 49);
		buttonNewGroup.addActionListener(this);
		frame.add(buttonNewGroup);

		buttonFinalizar = new JButton("Finalizar");
		buttonFinalizar.setEnabled(false);
		buttonFinalizar.setForeground(new Color(153, 0, 0));
		buttonFinalizar.setFont(Jstructure.FONT);
		buttonFinalizar.setBackground(Color.LIGHT_GRAY);
		buttonFinalizar.setBounds(601, 460, 107, 21);
		buttonFinalizar.addActionListener(this);
		frame.add(buttonFinalizar);

		frame.setVisible(true);
	}

	public JButton getButtonSelecionar() {
		return buttonSelecionar;
	}

	public JButton getButtonNovoAtor() {
		return buttonNewGroup;
	}

	public UserController getController() {
		return controller;
	}

	public JButton getButtonFinalizar() {
		return buttonFinalizar;
	}

	/**
	 * Executa o comando para o bot�o selecionado.
	 * 
	 * implementa��o da interface ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.sendAction(e.getSource());
	}

	public JList<String> getFieldGroups() {
		return fieldGroups;
	}

}