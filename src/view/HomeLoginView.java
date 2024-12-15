/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.AccountDAO;
import controller.RoomDAO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Account;
import model.RoomStatus;

/**
 *
 * @author Cuong
 */
public class HomeLoginView extends javax.swing.JFrame {

    private ArrayList<RoomStatus> roomStatus = new ArrayList<RoomStatus>();
    private RoomDAO roomDAO = new RoomDAO();
    private AccountDAO accountDAO = new AccountDAO();
    private Account account = new Account();
    private String position;

    /**
     * Creates new form Home
     */
    public HomeLoginView() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        login.setVisible(true);
        sroom.setVisible(false);
        signup.setVisible(false);
        btnSR.setVisible(false);
        btnSS.setVisible(false);

        setRoomStatus();
    }

    public Account setAccount(Account acc) {
        return acc;
    }

    public void setColorEnter(JPanel J) {
        J.setBackground(new Color(234, 234, 234));
    }

    public void setColorExited(JPanel J) {
        J.setBackground(new Color(255, 255, 255));
    }

    private void updateSRoom(String status, String id) {
        if (roomDAO.updateStatusRoom(status, id)) {
            srContent.removeAll();
            sroom.setVisible(false);
            sroom.setVisible(true);
            setRoomStatus();
            JOptionPane.showMessageDialog(rootPane, "Cập nhật trạng thái thành công!");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Không thể cập nhật trạng thái phòng hiện tại!");
        }
    }

    private void setRoomStatus() {
        roomStatus = roomDAO.getRoomStatus();
        srContent.setLayout(new GridLayout(6, 5, 4, 3));
        for (int i = 0; i < roomStatus.size(); i++) {
            String id = roomStatus.get(i).getID();
            JButton rs = new JButton("P" + roomStatus.get(i).getID() + ": " + roomStatus.get(i).getStatus());
            rs.setCursor(new Cursor(Cursor.HAND_CURSOR));
            rs.setFont(new Font("Segeo UI", Font.ITALIC, 13));
            rs.setForeground(new Color(246, 246, 246));

            if (roomStatus.get(i).getStatus().equals("Sẵn sàng")) {
                rs.setBackground(new Color(0, 183, 54));
                rs.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int conf = JOptionPane.showConfirmDialog(null,
                                "Phòng đang ở trạng thái sẵn sàng, bạn có muốn cập nhật lại?",
                                "Cập nhật trạng thái phòng",
                                JOptionPane.OK_CANCEL_OPTION);
                        if (conf == 0) {
                            String sInput = JOptionPane.showInputDialog(rootPane, "Trạng thái");
                            if (sInput != null) {
                                updateSRoom(sInput, id);
                            }
                        }
                    }
                });
            } else if (roomStatus.get(i).getStatus().equals("Đang sử dụng")) {
                String roomID = roomStatus.get(i).getID();
                rs.setBackground(new Color(18, 102, 241));
                rs.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String info = accountDAO.statusRoomInfo(roomID);
                        JOptionPane.showMessageDialog(null,
                                "Khách hàng: " + info, "Thông tin phòng hiện tại",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                });
            } else if (roomStatus.get(i).getStatus().equals("Chưa sẵn sàng")) {
                rs.setBackground(new Color(240, 169, 0));
                rs.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int conf = JOptionPane.showConfirmDialog(null,
                                "Bạn muốn cập nhận trạng thái phòng thành Sẵn sàng?",
                                "Cập nhật trạng thái phòng",
                                JOptionPane.OK_CANCEL_OPTION);
                        if (conf == 0) {
                            updateSRoom("Sẵn sàng", id);
                        }

                    }
                });
            } else {
                rs.setBackground(new Color(249, 49, 84));
                rs.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int conf = JOptionPane.showConfirmDialog(null,
                                "Bạn có muốn cập nhật lại trạng thái phòng hiện tại?",
                                "Cập nhật trạng thái phòng",
                                JOptionPane.OK_CANCEL_OPTION);
                        if (conf == 0) {
                            String sInput = JOptionPane.showInputDialog(rootPane, "Trạng thái");
                            if (sInput != null) {
                                updateSRoom(sInput, id);
                            }
                        }

                    }
                });
            }
            srContent.add(rs);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        Top = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Sidebar = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnBookService = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnCheckin = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        btnBookingList = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btnBook = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnBillList = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnCheckout = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnCustList = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnService = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnEmployee = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        btnStatistical = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnRoom = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btnSR = new javax.swing.JButton();
        btnSS = new javax.swing.JButton();
        content = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtUsernameLogin = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtPasswordLogin = new javax.swing.JPasswordField();
        signup = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        btnSignup = new javax.swing.JButton();
        btnLoginsi = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtPosition = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        sroom = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        srContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setBackground(new java.awt.Color(255, 255, 255));

        Top.setBackground(new java.awt.Color(7, 38, 109));
        Top.setPreferredSize(new java.awt.Dimension(180, 60));

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Booking.com");

        javax.swing.GroupLayout TopLayout = new javax.swing.GroupLayout(Top);
        Top.setLayout(TopLayout);
        TopLayout.setHorizontalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TopLayout.setVerticalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );

        Sidebar.setBackground(new java.awt.Color(255, 255, 255));
        Sidebar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(7, 38, 109)));
        Sidebar.setToolTipText("");
        Sidebar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Sidebar.setPreferredSize(new java.awt.Dimension(289, 455));

        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnBookService.setBackground(new java.awt.Color(255, 255, 255));
        btnBookService.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBookService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBookServiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBookServiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBookServiceMouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Đặt Dịch Vụ");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reception.png"))); // NOI18N

        javax.swing.GroupLayout btnBookServiceLayout = new javax.swing.GroupLayout(btnBookService);
        btnBookService.setLayout(btnBookServiceLayout);
        btnBookServiceLayout.setHorizontalGroup(
            btnBookServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBookServiceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnBookServiceLayout.setVerticalGroup(
            btnBookServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addGroup(btnBookServiceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnCheckin.setBackground(new java.awt.Color(255, 255, 255));
        btnCheckin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCheckin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCheckinMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCheckinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCheckinMouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Check In");

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-hotel-check-in-32.png"))); // NOI18N

        javax.swing.GroupLayout btnCheckinLayout = new javax.swing.GroupLayout(btnCheckin);
        btnCheckin.setLayout(btnCheckinLayout);
        btnCheckinLayout.setHorizontalGroup(
            btnCheckinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCheckinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64))
        );
        btnCheckinLayout.setVerticalGroup(
            btnCheckinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addGroup(btnCheckinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnBookingList.setBackground(new java.awt.Color(255, 255, 255));
        btnBookingList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBookingList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBookingListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBookingListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBookingListMouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("Danh Sách Đặt Phòng");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-list-32 (1).png"))); // NOI18N

        javax.swing.GroupLayout btnBookingListLayout = new javax.swing.GroupLayout(btnBookingList);
        btnBookingList.setLayout(btnBookingListLayout);
        btnBookingListLayout.setHorizontalGroup(
            btnBookingListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBookingListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(54, 54, 54))
        );
        btnBookingListLayout.setVerticalGroup(
            btnBookingListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addGroup(btnBookingListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnBook.setBackground(new java.awt.Color(255, 255, 255));
        btnBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBookMouseExited(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Đặt Phòng");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-booking-32.png"))); // NOI18N

        javax.swing.GroupLayout btnBookLayout = new javax.swing.GroupLayout(btnBook);
        btnBook.setLayout(btnBookLayout);
        btnBookLayout.setHorizontalGroup(
            btnBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBookLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnBookLayout.setVerticalGroup(
            btnBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addGroup(btnBookLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnBillList.setBackground(new java.awt.Color(255, 255, 255));
        btnBillList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBillList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBillListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBillListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBillListMouseExited(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Danh Sách Hóa Đơn Thuê Phòng");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-list-view-32.png"))); // NOI18N

        javax.swing.GroupLayout btnBillListLayout = new javax.swing.GroupLayout(btnBillList);
        btnBillList.setLayout(btnBillListLayout);
        btnBillListLayout.setHorizontalGroup(
            btnBillListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBillListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnBillListLayout.setVerticalGroup(
            btnBillListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addGroup(btnBillListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnCheckout.setBackground(new java.awt.Color(255, 255, 255));
        btnCheckout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCheckout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCheckoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCheckoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCheckoutMouseExited(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel13.setText("Check Out");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-hotel-check-out-32.png"))); // NOI18N

        javax.swing.GroupLayout btnCheckoutLayout = new javax.swing.GroupLayout(btnCheckout);
        btnCheckout.setLayout(btnCheckoutLayout);
        btnCheckoutLayout.setHorizontalGroup(
            btnCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCheckoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnCheckoutLayout.setVerticalGroup(
            btnCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addGroup(btnCheckoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnCustList.setBackground(new java.awt.Color(255, 255, 255));
        btnCustList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCustList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCustListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCustListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCustListMouseExited(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setText("Danh Sách Khách Hàng");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-profile-32.png"))); // NOI18N

        javax.swing.GroupLayout btnCustListLayout = new javax.swing.GroupLayout(btnCustList);
        btnCustList.setLayout(btnCustListLayout);
        btnCustListLayout.setHorizontalGroup(
            btnCustListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCustListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnCustListLayout.setVerticalGroup(
            btnCustListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnCustListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBookingList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCheckout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCheckin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBookService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCustList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBillList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBookService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBookingList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBillList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCustList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(311, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBillList, btnBook, btnBookService, btnBookingList, btnCheckin, btnCheckout, btnCustList});

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Sidebar.addTab("Khách Sạn", jPanel10);

        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnService.setBackground(new java.awt.Color(255, 255, 255));
        btnService.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnServiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnServiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnServiceMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Dịch Vụ");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-service-32-l.png"))); // NOI18N

        javax.swing.GroupLayout btnServiceLayout = new javax.swing.GroupLayout(btnService);
        btnService.setLayout(btnServiceLayout);
        btnServiceLayout.setHorizontalGroup(
            btnServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnServiceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnServiceLayout.setVerticalGroup(
            btnServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addGroup(btnServiceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnEmployee.setBackground(new java.awt.Color(255, 255, 255));
        btnEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmployeeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEmployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEmployeeMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Nhân Viên");

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-employees-32.png"))); // NOI18N

        javax.swing.GroupLayout btnEmployeeLayout = new javax.swing.GroupLayout(btnEmployee);
        btnEmployee.setLayout(btnEmployeeLayout);
        btnEmployeeLayout.setHorizontalGroup(
            btnEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnEmployeeLayout.setVerticalGroup(
            btnEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addGroup(btnEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnStatistical.setBackground(new java.awt.Color(255, 255, 255));
        btnStatistical.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStatistical.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStatisticalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnStatisticalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnStatisticalMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Thống Kê");

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-statistics-32.png"))); // NOI18N

        javax.swing.GroupLayout btnStatisticalLayout = new javax.swing.GroupLayout(btnStatistical);
        btnStatistical.setLayout(btnStatisticalLayout);
        btnStatisticalLayout.setHorizontalGroup(
            btnStatisticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnStatisticalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnStatisticalLayout.setVerticalGroup(
            btnStatisticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addGroup(btnStatisticalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnRoom.setBackground(new java.awt.Color(255, 255, 255));
        btnRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRoom.setPreferredSize(new java.awt.Dimension(261, 51));
        btnRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRoomMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRoomMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRoomMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Phòng Khách Sạn");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-bed-32.png"))); // NOI18N

        javax.swing.GroupLayout btnRoomLayout = new javax.swing.GroupLayout(btnRoom);
        btnRoom.setLayout(btnRoomLayout);
        btnRoomLayout.setHorizontalGroup(
            btnRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRoomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addGap(73, 73, 73))
        );
        btnRoomLayout.setVerticalGroup(
            btnRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addGroup(btnRoomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSR.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSR.setText("Theo Phòng");
        btnSR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSRActionPerformed(evt);
            }
        });

        btnSS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSS.setText("Theo dịch vụ");
        btnSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnStatistical, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnSR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSS, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSR, btnSS});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStatistical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSR)
                    .addComponent(btnSS, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(437, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnEmployee, btnRoom, btnService, btnStatistical});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSR, btnSS});

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Sidebar.addTab("Quản Lý", jPanel11);

        login.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ĐĂNG NHẬP");

        jPanel5.setBackground(new java.awt.Color(7, 38, 109));
        jPanel5.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Password:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Username:");

        txtUsernameLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnLogin.setBackground(new java.awt.Color(0, 113, 194));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Log in");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel16.setText("* Sign Up");
        jLabel16.setToolTipText("");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));

        txtPasswordLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(loginLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, loginLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(loginLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(loginLayout.createSequentialGroup()
                                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(187, 187, 187))
                                    .addComponent(txtPasswordLogin)))
                            .addGroup(loginLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(txtUsernameLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 178, Short.MAX_VALUE)))
                .addContainerGap())
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsernameLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtPasswordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(441, Short.MAX_VALUE))
        );

        signup.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("ĐĂNG KÝ");

        jPanel6.setBackground(new java.awt.Color(7, 38, 109));
        jPanel6.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel31.setText("Username:");

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel32.setText("Password:");

        btnSignup.setBackground(new java.awt.Color(0, 113, 194));
        btnSignup.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSignup.setForeground(new java.awt.Color(255, 255, 255));
        btnSignup.setText("Sign up");
        btnSignup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });

        btnLoginsi.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        btnLoginsi.setText("* Log In");
        btnLoginsi.setToolTipText("");
        btnLoginsi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLoginsi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginsiMouseClicked(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel33.setText("Họ Tên:");

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel34.setText("Số điện thoại:");

        txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel35.setText("Chức vụ:");

        txtPosition.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout signupLayout = new javax.swing.GroupLayout(signup);
        signup.setLayout(signupLayout);
        signupLayout.setHorizontalGroup(
            signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
            .addGroup(signupLayout.createSequentialGroup()
                .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoginsi, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(signupLayout.createSequentialGroup()
                        .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(signupLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel33))
                                .addGap(18, 18, 18)
                                .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                                    .addComponent(txtPosition, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)))
                            .addGroup(signupLayout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addComponent(btnSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 177, Short.MAX_VALUE)))
                .addContainerGap())
        );
        signupLayout.setVerticalGroup(
            signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupLayout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoginsi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(18, 18, 18)
                .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addGap(18, 18, 18)
                .addComponent(btnSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(303, Short.MAX_VALUE))
        );

        sroom.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(7, 38, 109));
        jPanel7.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 699, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("TRẠNG THÁI PHÒNG");

        srContent.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout srContentLayout = new javax.swing.GroupLayout(srContent);
        srContent.setLayout(srContentLayout);
        srContentLayout.setHorizontalGroup(
            srContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        srContentLayout.setVerticalGroup(
            srContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout sroomLayout = new javax.swing.GroupLayout(sroom);
        sroom.setLayout(sroomLayout);
        sroomLayout.setHorizontalGroup(
            sroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sroomLayout.createSequentialGroup()
                .addGroup(sroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                    .addComponent(srContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        sroomLayout.setVerticalGroup(
            sroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sroomLayout.createSequentialGroup()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(srContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(signup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(sroom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(signup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(sroom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Top, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addComponent(Top, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                    .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookMouseEntered
        setColorEnter(btnBook);
    }//GEN-LAST:event_btnBookMouseEntered

    private void btnBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookMouseExited
        setColorExited(btnBook);
    }//GEN-LAST:event_btnBookMouseExited

    private void btnBookServiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookServiceMouseEntered
        setColorEnter(btnBookService);
    }//GEN-LAST:event_btnBookServiceMouseEntered

    private void btnBookServiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookServiceMouseExited
        setColorExited(btnBookService);
    }//GEN-LAST:event_btnBookServiceMouseExited

    private void btnCheckinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckinMouseEntered
        setColorEnter(btnCheckin);
    }//GEN-LAST:event_btnCheckinMouseEntered

    private void btnCheckinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckinMouseExited
        setColorExited(btnCheckin);
    }//GEN-LAST:event_btnCheckinMouseExited

    private void btnCheckoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckoutMouseEntered
        setColorEnter(btnCheckout);
    }//GEN-LAST:event_btnCheckoutMouseEntered

    private void btnCheckoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckoutMouseExited
        setColorExited(btnCheckout);
    }//GEN-LAST:event_btnCheckoutMouseExited

    private void btnBookingListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookingListMouseEntered
        setColorEnter(btnBookingList);
    }//GEN-LAST:event_btnBookingListMouseEntered

    private void btnBookingListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookingListMouseExited
        setColorExited(btnBookingList);
    }//GEN-LAST:event_btnBookingListMouseExited

    private void btnBillListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBillListMouseEntered
        setColorEnter(btnBillList);
    }//GEN-LAST:event_btnBillListMouseEntered

    private void btnBillListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBillListMouseExited
        setColorExited(btnBillList);
    }//GEN-LAST:event_btnBillListMouseExited

    private void btnCustListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustListMouseEntered
        setColorEnter(btnCustList);
    }//GEN-LAST:event_btnCustListMouseEntered

    private void btnCustListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustListMouseExited
        setColorExited(btnCustList);
    }//GEN-LAST:event_btnCustListMouseExited

    private void btnRoomMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRoomMouseEntered
        setColorEnter(btnRoom);
    }//GEN-LAST:event_btnRoomMouseEntered

    private void btnRoomMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRoomMouseExited
        setColorExited(btnRoom);
    }//GEN-LAST:event_btnRoomMouseExited

    private void btnServiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServiceMouseEntered
        setColorEnter(btnService);
    }//GEN-LAST:event_btnServiceMouseEntered

    private void btnServiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServiceMouseExited
        setColorExited(btnService);
    }//GEN-LAST:event_btnServiceMouseExited

    private void btnEmployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeMouseEntered
        setColorEnter(btnEmployee);
    }//GEN-LAST:event_btnEmployeeMouseEntered

    private void btnEmployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeMouseExited
        setColorExited(btnEmployee);
    }//GEN-LAST:event_btnEmployeeMouseExited

    private void btnStatisticalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatisticalMouseEntered
        setColorEnter(btnStatistical);
    }//GEN-LAST:event_btnStatisticalMouseEntered

    private void btnStatisticalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatisticalMouseExited
        setColorExited(btnStatistical);
    }//GEN-LAST:event_btnStatisticalMouseExited

    private void btnBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookMouseClicked
       JOptionPane.showMessageDialog(rootPane, "Ðăng nhập để sử dụng chức năng này!");
    }//GEN-LAST:event_btnBookMouseClicked

    private void btnCheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckinActionPerformed

    }//GEN-LAST:event_btnCheckinActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        new CheckOutView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCheckOutActionPerformed

    private void btnRoomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoomsActionPerformed
        new RoomView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRoomsActionPerformed


    private void btnCustumerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustumerActionPerformed
        this.dispose();
        new CustomerView().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCustumerActionPerformed

    private void btnBookingListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookingListActionPerformed
        new BookingListView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBookingListActionPerformed


    private void btnBookServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookServiceMouseClicked
       JOptionPane.showMessageDialog(rootPane, "Ðăng nhập để sử dụng chức năng này!");
    }//GEN-LAST:event_btnBookServiceMouseClicked


    private void btnBookingListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookingListMouseClicked
       JOptionPane.showMessageDialog(rootPane, "Ðăng nhập để sử dụng chức năng này!");
    }//GEN-LAST:event_btnBookingListMouseClicked

    private void btnCustListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustListMouseClicked
        JOptionPane.showMessageDialog(rootPane, "Ðăng nhập để sử dụng chức năng này!");
    }//GEN-LAST:event_btnCustListMouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (txtUsernameLogin.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                    "Username không được để trống!", "Login không thành công", JOptionPane.ERROR_MESSAGE);
        } else if (txtPasswordLogin.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                    "Password không được để trống!", "Login không thành công", JOptionPane.ERROR_MESSAGE);
        } else {
            Account accLogin = new Account();
            accLogin.setUsername(txtUsernameLogin.getText());
            accLogin.setPassword(txtPasswordLogin.getText());
            Account account = accountDAO.login(accLogin);
            if (account == null) {
                JOptionPane.showMessageDialog(null,
                        "Username hoặc password không chính xác!", "Login không thành công", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Xin chào " + account.getName(), "Login thành công", JOptionPane.INFORMATION_MESSAGE);
                this.position = account.getPosition();
                HomeView homeView = new HomeView();
                homeView.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        login.setVisible(false);
        sroom.setVisible(false);
        signup.setVisible(true);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        if (txtUsername.getText().equals("") || txtPassword.getText().equals("") || txtPosition.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Hãy điền đầy đủ thông tin cần thiết!");
        } else {
            Account acc = new Account();
            acc.setUsername(txtUsername.getText());
            acc.setPassword(txtPassword.getText());
            acc.setName(txtName.getText());
            acc.setPosition(txtPosition.getText());
            acc.setPhone(txtPhone.getText());            
     
            Account a = accountDAO.register(acc);
            if (a == null) {
                JOptionPane.showMessageDialog(null,
                        "Vui lòng xem lại thông tin!", "Signup không thành công", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Đăng ký thành công!, xin chào " + acc.getName(), "Login thành công", JOptionPane.INFORMATION_MESSAGE);
                this.position = a.getPosition();
                HomeView homeView = new HomeView();
                homeView.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnSignupActionPerformed

    private void btnLoginsiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginsiMouseClicked
        sroom.setVisible(false);
        signup.setVisible(false);
        login.setVisible(true);
    }//GEN-LAST:event_btnLoginsiMouseClicked

    private void btnCheckinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckinMouseClicked
        JOptionPane.showMessageDialog(rootPane, "Ðăng nhập để sử dụng chức năng này!");
    }//GEN-LAST:event_btnCheckinMouseClicked

    private void btnCheckoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckoutMouseClicked
        JOptionPane.showMessageDialog(rootPane, "Ðăng nhập để sử dụng chức năng này!");
    }//GEN-LAST:event_btnCheckoutMouseClicked

    private void btnRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRoomMouseClicked
        JOptionPane.showMessageDialog(rootPane, "Ðăng nhập để sử dụng chức năng này!");
    }//GEN-LAST:event_btnRoomMouseClicked

    private void btnSRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSRActionPerformed
       JOptionPane.showMessageDialog(rootPane, "Ðăng nhập để sử dụng chức năng này!");
    }//GEN-LAST:event_btnSRActionPerformed

    private void btnSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSSActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Ðăng nhập để sử dụng chức năng này!");
    }//GEN-LAST:event_btnSSActionPerformed

    private void btnStatisticalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatisticalMouseClicked
        JOptionPane.showMessageDialog(rootPane, "Ðăng nhập để sử dụng chức năng này!");
    }//GEN-LAST:event_btnStatisticalMouseClicked

    private void btnEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeMouseClicked
        JOptionPane.showMessageDialog(rootPane, "Ðăng nhập để sử dụng chức năng này!");
    }//GEN-LAST:event_btnEmployeeMouseClicked

    private void btnServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServiceMouseClicked
       JOptionPane.showMessageDialog(rootPane, "Ðăng nhập để sử dụng chức năng này!");
    }//GEN-LAST:event_btnServiceMouseClicked

    private void btnBillListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBillListMouseClicked
        JOptionPane.showMessageDialog(rootPane, "Ðăng nhập để sử dụng chức năng này!");
    }//GEN-LAST:event_btnBillListMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeLoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeLoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeLoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeLoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeLoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JTabbedPane Sidebar;
    private javax.swing.JPanel Top;
    private javax.swing.JPanel btnBillList;
    private javax.swing.JPanel btnBook;
    private javax.swing.JPanel btnBookService;
    private javax.swing.JPanel btnBookingList;
    private javax.swing.JPanel btnCheckin;
    private javax.swing.JPanel btnCheckout;
    private javax.swing.JPanel btnCustList;
    private javax.swing.JPanel btnEmployee;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel btnLoginsi;
    private javax.swing.JPanel btnRoom;
    private javax.swing.JButton btnSR;
    private javax.swing.JButton btnSS;
    private javax.swing.JPanel btnService;
    private javax.swing.JButton btnSignup;
    private javax.swing.JPanel btnStatistical;
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel login;
    private javax.swing.JPanel signup;
    private javax.swing.JPanel srContent;
    private javax.swing.JPanel sroom;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordLogin;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUsernameLogin;
    // End of variables declaration//GEN-END:variables
}
