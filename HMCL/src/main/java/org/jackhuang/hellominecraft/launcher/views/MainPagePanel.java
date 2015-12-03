/*
 * Copyright 2013 huangyuhui <huanghongxun2008@126.com>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.
 */
package org.jackhuang.hellominecraft.launcher.views;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import javax.swing.SwingUtilities;
import org.jackhuang.hellominecraft.C;
import org.jackhuang.hellominecraft.HMCLog;
import org.jackhuang.hellominecraft.launcher.launch.DefaultGameLauncher;
import org.jackhuang.hellominecraft.launcher.utils.auth.IAuthenticator;
import org.jackhuang.hellominecraft.launcher.utils.auth.LoginInfo;
import org.jackhuang.hellominecraft.launcher.settings.Profile;
import org.jackhuang.hellominecraft.utils.system.MessageBox;
import org.jackhuang.hellominecraft.utils.StrUtils;
import org.jackhuang.hellominecraft.launcher.version.MinecraftVersion;
import org.jackhuang.hellominecraft.launcher.launch.GameLauncher;
import org.jackhuang.hellominecraft.launcher.launch.LaunchFinisher;
import org.jackhuang.hellominecraft.launcher.launch.LaunchScriptFinisher;
import org.jackhuang.hellominecraft.launcher.settings.Settings;
import org.jackhuang.hellominecraft.lookandfeel.GraphicsUtils;
import org.jackhuang.hellominecraft.utils.Event;
import org.jackhuang.hellominecraft.lookandfeel.components.ConstomButton;
import org.jackhuang.hellominecraft.utils.functions.Consumer;

/**
 *
 * @author huangyuhui
 */
public class MainPagePanel extends javax.swing.JPanel {

    /**
     * Creates new form MainPagePanel
     */
    public MainPagePanel() {
        initComponents();

        pnlButtons = new javax.swing.JPanel();
        pnlButtons.setLayout(null);

        int w = 150, h = 50;
        btnRun = new ConstomButton();
        btnRun.setBounds(0, 0, w, h);
        Font font = btnRun.getFont();
        Font newFont = new Font(font.getName(), font.getStyle(), 15);
        pnlButtons.add(btnRun);

        btnRun.setText(C.i18n("ui.button.run"));
        btnRun.setFont(newFont);
        btnRun.addActionListener(e -> btnRunActionPerformed());

        this.add(pnlButtons);
        pnlButtons.setBounds(0, 0, w, h);

        this.setSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        this.pnlButtons.setLocation(DEFAULT_WIDTH - pnlButtons.getWidth() - 25, DEFAULT_HEIGHT - pnlButtons.getHeight() - 25);
        pnlMore.setBounds(0, 0, pnlMore.getWidth(), DEFAULT_HEIGHT);
        pnlMore.setBackground(GraphicsUtils.getWebColorWithAlpha("FFFFFF7F"));
        pnlMore.setOpaque(true);

        prepareAuths();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMore = new javax.swing.JPanel();
        txtPlayerName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboLoginMode = new javax.swing.JComboBox();
        lblUserName = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboProfiles = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        cboVersions = new javax.swing.JComboBox();
        pnlPassword = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();

        setLayout(null);

        pnlMore.setBackground(new java.awt.Color(204, 204, 204));
        pnlMore.setOpaque(false);

        txtPlayerName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPlayerNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPlayerNameFocusLost(evt);
            }
        });
        txtPlayerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPlayerNameKeyPressed(evt);
            }
        });

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/jackhuang/hellominecraft/launcher/I18N"); // NOI18N
        jLabel7.setText(bundle.getString("login.type")); // NOI18N

        cboLoginMode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLoginModeItemStateChanged(evt);
            }
        });

        lblUserName.setText(bundle.getString("login.username")); // NOI18N

        jLabel10.setText(bundle.getString("ui.label.profile")); // NOI18N

        cboProfiles.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboProfilesItemStateChanged(evt);
            }
        });

        jLabel1.setText(C.I18N.getString("ui.label.version")); // NOI18N
        jLabel1.setToolTipText(bundle.getString("ui.label.version")); // NOI18N

        cboVersions.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboVersionsItemStateChanged(evt);
            }
        });

        pnlPassword.setLayout(new java.awt.CardLayout());

        jLabel9.setText(bundle.getString("ui.label.password")); // NOI18N

        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlPassword.add(jPanel1, "card2");

        btnLogout.setText(C.I18N.getString("ui.button.logout")); // NOI18N
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        pnlPassword.add(jPanel3, "card3");

        javax.swing.GroupLayout pnlMoreLayout = new javax.swing.GroupLayout(pnlMore);
        pnlMore.setLayout(pnlMoreLayout);
        pnlMoreLayout.setHorizontalGroup(
            pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMoreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlMoreLayout.createSequentialGroup()
                        .addGroup(pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboProfiles, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboVersions, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlMoreLayout.createSequentialGroup()
                        .addGroup(pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUserName)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboLoginMode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPlayerName))))
                .addContainerGap())
        );
        pnlMoreLayout.setVerticalGroup(
            pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMoreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cboProfiles, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboVersions, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboLoginMode, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName)
                    .addComponent(txtPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(316, Short.MAX_VALUE))
        );

        add(pnlMore);
        pnlMore.setBounds(0, 0, 190, 480);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlayerNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPlayerNameFocusGained
        MainFrame.INSTANCE.closeMessage();
    }//GEN-LAST:event_txtPlayerNameFocusGained

    private void txtPlayerNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPlayerNameFocusLost
        Settings.getInstance().setUsername(txtPlayerName.getText());
    }//GEN-LAST:event_txtPlayerNameFocusLost

    private void cboLoginModeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLoginModeItemStateChanged
        if (preaparingAuth)
            return;
        int index = cboLoginMode.getSelectedIndex();
        if (index < 0)
            return;

        IAuthenticator l = IAuthenticator.LOGINS.get(index);
        if (l.isHidePasswordBox()) {
            pnlPassword.setVisible(false);
            lblUserName.setText(C.i18n("login.username"));
        } else {
            pnlPassword.setVisible(true);
            lblUserName.setText(C.i18n("login.account"));
        }

        CardLayout cl = (CardLayout) pnlPassword.getLayout();
        if (l.isLoggedIn())
            cl.last(pnlPassword);
        else
            cl.first(pnlPassword);
        String username = Settings.getInstance().getUsername();
        if (StrUtils.isNotBlank(username))
            txtPlayerName.setText(username);

        Settings.getInstance().setLoginType(index);
    }//GEN-LAST:event_cboLoginModeItemStateChanged

    private void cboProfilesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboProfilesItemStateChanged
        if (!isLoading && cboProfiles.getSelectedIndex() != -1 && !StrUtils.isBlank((String) cboProfiles.getSelectedItem())) {
            Settings.getInstance().setLast((String) cboProfiles.getSelectedItem());
            loadMinecraftVersions();
        }
    }//GEN-LAST:event_cboProfilesItemStateChanged

    private void cboVersionsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboVersionsItemStateChanged
        if (isLoading || evt.getStateChange() != ItemEvent.SELECTED || cboVersions.getSelectedIndex() < 0 || StrUtils.isBlank((String) cboVersions.getSelectedItem()) || getCurrentProfile() == null)
            return;
        getCurrentProfile().setSelectedMinecraftVersion(cboVersions.getSelectedItem().toString());
        cboVersions.setToolTipText(cboVersions.getSelectedItem().toString());
        Settings.save();
    }//GEN-LAST:event_cboVersionsItemStateChanged

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        MainFrame.INSTANCE.closeMessage();
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        btnRunActionPerformed();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        if (preaparingAuth)
            return;
        int index = cboLoginMode.getSelectedIndex();

        IAuthenticator l = IAuthenticator.LOGINS.get(index);
        CardLayout cl = (CardLayout) pnlPassword.getLayout();
        if (l.isLoggedIn())
            l.logout();
        cl.first(pnlPassword);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void txtPlayerNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlayerNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Settings.getInstance().setUsername(txtPlayerName.getText());
            int index = cboLoginMode.getSelectedIndex();
            if (index < 0)
                return;
            IAuthenticator l = IAuthenticator.LOGINS.get(index);
            if (l.isHidePasswordBox())
                btnRunActionPerformed();
            else if (!l.isLoggedIn())
                txtPassword.requestFocus();
        }
    }//GEN-LAST:event_txtPlayerNameKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            btnRunActionPerformed();
    }//GEN-LAST:event_txtPasswordKeyPressed

    boolean isLaunching = false;

    // <editor-fold defaultstate="collapsed" desc="Game Launch">
    void genLaunchCode(final Consumer<GameLauncher> listener) {
        if (isLaunching || getCurrentProfile() == null)
            return;
        isLaunching = true;
        HMCLog.log("Start generating launching command...");
        File file = getCurrentProfile().getCanonicalGameDirFile();
        if (!file.exists()) {
            HMCLog.warn("The minecraft path is wrong, please check it yourself.");
            MessageBox.Show(C.i18n("minecraft.wrong_path"));
            return;
        }
        final String name = (String) cboProfiles.getSelectedItem();
        if (StrUtils.isBlank(name) || getCurrentProfile().getSelectedMinecraftVersion() == null) {
            HMCLog.warn("There's no selected version, rechoose a version.");
            MessageBox.Show(C.i18n("minecraft.no_selected_version"));
            return;
        }

        final int index = cboLoginMode.getSelectedIndex();
        if (index < 0 || index >= IAuthenticator.LOGINS.size()) {
            HMCLog.warn("There's no login method.");
            MessageBox.Show(C.i18n("login.methods.no_method"));
            return;
        }
        final IAuthenticator l = IAuthenticator.LOGINS.get(index);
        final LoginInfo li = new LoginInfo(Settings.getInstance().getUsername(), l.isLoggedIn() || l.isHidePasswordBox() ? null : new String(txtPassword.getPassword()));
        Thread t = new Thread() {
            @Override
            public void run() {
                Thread.currentThread().setName("Game Launcher");
                DefaultGameLauncher gl = new DefaultGameLauncher(getCurrentProfile(), li, l, Settings.getInstance().getDownloadSource());
                gl.failEvent.register((sender, s) -> {
                    if (s != null)
                        MessageBox.Show(s);
                    MainFrame.INSTANCE.closeMessage();
                    isLaunching = false;
                    return true;
                });
                gl.successEvent.register((sender, s) -> {
                    isLaunching = false;
                    return true;
                });
                listener.accept(gl);
                gl.makeLaunchCommand();
            }
        };
        t.start();
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Loads">
    private void prepareAuths() {
        preaparingAuth = true;
        cboLoginMode.removeAllItems();
        for (IAuthenticator str : IAuthenticator.LOGINS)
            try {
                cboLoginMode.addItem(str.getName());
            } catch (Exception ex) {
                HMCLog.warn("Failed to get login name", ex);
            }
        int loginType = Settings.getInstance().getLoginType();
        if (0 <= loginType && loginType < cboLoginMode.getItemCount()) {
            preaparingAuth = false;

            cboLoginMode.setSelectedIndex(loginType);

            cboLoginModeItemStateChanged(null);
        }
    }

    void loadFromSettings() {
        for (Profile s : Settings.getProfilesFiltered())
            cboProfiles.addItem(s.getName());
    }

    boolean showedNoVersion = false;

    void loadMinecraftVersions() {
        isLoading = true;
        cboVersions.removeAllItems();
        int index = 0, i = 0;
        if (getCurrentProfile() != null) {
            getCurrentProfile().getMinecraftProvider().refreshVersions();
            MinecraftVersion selVersion = getCurrentProfile().getSelectedMinecraftVersion();
            String selectedMC = selVersion == null ? null : selVersion.id;
            if (getCurrentProfile().getMinecraftProvider().getVersions().isEmpty()) {
                if (!showedNoVersion)
                    SwingUtilities.invokeLater(() -> {
                        if (MessageBox.Show(C.i18n("mainwindow.no_version"), MessageBox.YES_NO_OPTION) == MessageBox.YES_OPTION) {
                            MainFrame.INSTANCE.selectTab("game");
                            MainFrame.INSTANCE.gamePanel.showGameDownloads();
                        }
                        showedNoVersion = true;
                    });
            } else {
                for (MinecraftVersion mcVersion : getCurrentProfile().getMinecraftProvider().getVersions()) {
                    if (mcVersion.hidden)
                        continue;
                    cboVersions.addItem(mcVersion.id);
                    if (mcVersion.id.equals(selectedMC))
                        index = i;
                    i++;
                }
                if (index < cboVersions.getItemCount())
                    cboVersions.setSelectedIndex(index);
            }
        }
        isLoading = false;
    }

    private void refreshMinecrafts(String last) {
        isLoading = true;
        cboProfiles.removeAllItems();
        loadFromSettings();
        for (int i = 0; i < cboProfiles.getItemCount(); i++) {
            String s = (String) cboProfiles.getItemAt(i);
            if (s != null && s.equals(last)) {
                cboProfiles.setSelectedIndex(i);
                break;
            }
        }
        isLoading = false;
        loadMinecraftVersions();
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Private Variables">
    boolean preaparingAuth = true;
    private boolean isLoading = false;
    private final javax.swing.JPanel pnlButtons;
    private final ConstomButton btnRun;
    private static final int DEFAULT_WIDTH = 800, DEFAULT_HEIGHT = 480;
    //</editor-fold>

    class PrepareAuthDoneListener implements Event<List<String>> {

        @Override
        public boolean call(Object sender, List<String> value) {
            prepareAuths();
            return true;
        }
    }

    private void btnRunActionPerformed() {
        MainFrame.INSTANCE.showMessage(C.i18n("ui.message.launching"));
        genLaunchCode(value -> {
            value.successEvent.register(new LaunchFinisher());
            value.successEvent.register(new PrepareAuthDoneListener());
        });
    }

    public void btnMakeLaunchCodeActionPerformed() {
        MainFrame.INSTANCE.showMessage(C.i18n("ui.message.launching"));
        genLaunchCode(value -> {
            value.successEvent.register(new LaunchScriptFinisher());
            value.successEvent.register(new PrepareAuthDoneListener());
        });
    }

    public void onShow(boolean showLeft) {
        if (showLeft)
            SwingUtilities.invokeLater(() -> MainFrame.INSTANCE.showMessage(C.i18n("ui.message.first_load")));
        if (cboLoginMode.getSelectedIndex() >= 0 && cboLoginMode.getSelectedIndex() < cboLoginMode.getItemCount()) {
            IAuthenticator l = IAuthenticator.LOGINS.get(cboLoginMode.getSelectedIndex());
            if (!l.isHidePasswordBox() && !l.isLoggedIn())
                SwingUtilities.invokeLater(() -> MainFrame.INSTANCE.showMessage(C.i18n("ui.message.enter_password")));
        }
    }

    public Profile getCurrentProfile() {
        return Settings.getProfile((String) cboProfiles.getSelectedItem());
    }

    public void onSelected() {
        refreshMinecrafts(Settings.getInstance().getLast());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JComboBox cboLoginMode;
    private javax.swing.JComboBox cboProfiles;
    private javax.swing.JComboBox cboVersions;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPanel pnlMore;
    private javax.swing.JPanel pnlPassword;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPlayerName;
    // End of variables declaration//GEN-END:variables
}
