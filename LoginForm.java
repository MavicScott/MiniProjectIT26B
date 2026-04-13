import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        Connection con = DBConnection.connect();

        String sql = "INSERT INTO users(username, password) VALUES (?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setString(1, txtUsername.getText());
        pst.setString(2, txtPassword.getText());

        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Registered Successfully!");
        
        txtUsername.setText("");
        txtPassword.setText("");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
    }
}