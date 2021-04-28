
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class MyJavaFX extends Application {

	public void start(Stage Stage) {

		Button ipconfig = new Button("IPConfig /all");

		Button rr = new Button("IP Release/Renew");

		Button ma = new Button("Machine Actions");

		TilePane tp = new TilePane();
		tp.setAlignment(Pos.TOP_LEFT);
		tp.setHgap(5);
		tp.setVgap(5);

		Scene scene = new Scene(tp);

		tp.getChildren().add(ipconfig);
		ipconfig.setOnAction(e -> {
			try {
				Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"ipconfig /all\"");
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		});

		tp.getChildren().add(rr);
		rr.setOnAction(e -> {
			try {
				Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"ipconfig /release && ipconfig /renew\"");

			} catch (IOException e1) {

				e1.printStackTrace();
			}
		});

		tp.getChildren().add(ma);
		ma.setOnAction(e -> {
			try {
				// open CMD and browse to the WMIC application
				Runtime.getRuntime().exec("cmd /c start cmd.exe /K C:\\Windows\\System32\\wbem\\wmic"

					// run Application Deployment Evaluation Cycle
					+ " && /namespace:\\\\root\\ccm path sms_client CALL TriggerSchedule \"{00000000-0000-0000-0000-000000000123}\" /NOINTERACTIVE"

				// run Discovery Data Collection Cycle
				// + " \"/namespace:\\\\root\\ccm path sms_client CALL TriggerSchedule
				// \"{00000000-0000-0000-0000-000000000103}\" /NOINTERACTIVE\""

				/**
				 * // run File Collection Cycle + " && /namespace:\\\\root\\ccm path sms_client
				 * CALL TriggerSchedule \"{00000000-0000-0000-0000-000000000104}\"
				 * /NOINTERACTIVE\""
				 * 
				 * // run Hardware Inventory Cycle + " && /namespace:\\\\root\\ccm path
				 * sms_client CALL TriggerSchedule \"{00000000-0000-0000-0000-000000000101}\"
				 * /NOINTERACTIVE\""
				 * 
				 * // run Machine Policy Retrieval & Evaluation Cycle
				 * 
				 * 
				 * 
				 * // run Software Inventory Cycle + " && /namespace:\\\\root\\ccm path
				 * sms_client CALL TriggerSchedule \"{00000000-0000-0000-0000-000000000002}\"
				 * /NOINTERACTIVE\""
				 * 
				 * // run Software Metering Usage Report Cycle + " && /namespace:\\\\root\\ccm
				 * path sms_client CALL TriggerSchedule
				 * \"{00000000-0000-0000-0000-000000000031}\" /NOINTERACTIVE\""
				 * 
				 * // run User Policy Retrieval & Evaluation Cycle
				 * 
				 * 
				 * // run Windows Installer Source List Update Cycle + " &&
				 * /namespace:\\\\root\\ccm path sms_client CALL TriggerSchedule
				 * \"{00000000-0000-0000-0000-000000000107}\" /NOINTERACTIVE\""
				 * 
				 * 
				 * 
				 **/
				);

			} catch (IOException e1) {

				e1.printStackTrace();
			}
		});

		Stage.setTitle("CSR Utility by: Zach Swogger");

		Stage.setHeight(500);

		Stage.setWidth(1000);

		Stage.setScene(scene);

		Stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}