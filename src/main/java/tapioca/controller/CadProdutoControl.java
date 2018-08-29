package tapioca.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import tapioca.dao.ProdutoDAO;
import tapioca.entity.Produto;

public class CadProdutoControl implements Initializable {

	@FXML
	private TableView<Produto> tableViewProduto;
	@FXML
	private TableColumn<Produto, String> tableColumnCodigo;
	@FXML
	private TableColumn<Produto, String> tableColumnNome;
	@FXML
	private TableColumn<Produto, Integer> tableColumnId;
	@FXML
	private TableColumn<Produto, Double> tableColumnValor;
	@FXML
	private Button btnSalvarProduto;

	@FXML
	private Button btnExluirProduto;

	@FXML
	private Label txtValorProduto;
	@FXML
	private Label txtNomeProduto;
	@FXML
	private Label txtCodProduto;
	@FXML
	AnchorPane anchorPane;
	private Produto produto;
	private List<Produto> listProdutos;
	private static ObservableList<Produto> observableListProdutos;
	private ProdutoDAO dao = new ProdutoDAO();

	public void initialize(URL location, ResourceBundle resources) {
		carregaTableViewProduto();
		tableViewProduto.getSelectionModel().selectedItemProperty()
				.addListener((observableListProdutos, oldvalue, newValue) -> selecionarProduto(newValue));
	}

	private void carregaTableViewProduto() {

		tableColumnId.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("id"));

		tableColumnCodigo.setCellValueFactory(new PropertyValueFactory<Produto, String>("codigo"));
		tableColumnValor.setCellValueFactory(new PropertyValueFactory<Produto, Double>("valor"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
		listProdutos = dao.listProduto();
		observableListProdutos = FXCollections.observableArrayList(listProdutos);
		tableViewProduto.setItems(observableListProdutos);

	}

	@FXML
	public void salvarProduto() throws IOException {
		dao.addProduto(new Produto(txtCodProduto.getText(), txtNomeProduto.getText(),
				Double.parseDouble(txtValorProduto.getText())));
		AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/CadProdutos.fxml"));
		anchorPane.getChildren().setAll(a);
	}


	@FXML
	public void adicionarProduto(){

	}

	public void selecionarProduto(Produto produtoselecionado) {
		produto = produtoselecionado;
		txtCodProduto.setText(produto.getCodigo());
		txtNomeProduto.setText(produto.getNome());
		txtValorProduto.setText(String.valueOf(produto.getValor()));

	}

	@FXML
	public void excluirProduto() throws IOException {
		dao.removeProduto(produto);
		AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/CadProdutos.fxml"));
		anchorPane.getChildren().setAll(a);

	}
}