package com.atguigu.demo.test.day2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class TwoDArrayUI extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    public TwoDArrayUI() {
        setTitle("二维数组头部插入演示");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // 顶部输入区
        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topPanel.add(new JLabel("输入数组（逗号分隔）："), BorderLayout.WEST);

        inputField = new JTextField("1,2,3,4,5,6,7,8,9,10,11,12,13,14");
        topPanel.add(inputField, BorderLayout.CENTER);

        JButton convertBtn = new JButton("转换");
        topPanel.add(convertBtn, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // 中间输出区
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // 按钮事件
        convertBtn.addActionListener(this::convert);

        setVisible(true);
    }

    private void convert(ActionEvent e) {
        outputArea.setText("");
        String input = inputField.getText().trim();

        if (input.isEmpty()) {
            outputArea.append("请输入数组内容！\n");
            return;
        }

        String[] parts = input.split("\\s*,\\s*");
        int[] arr = new int[parts.length];

        try {
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
        } catch (NumberFormatException ex) {
            outputArea.append("输入格式错误，请确保都是整数，用逗号分隔。\n");
            return;
        }

        // 使用二维数组，每行一个元素
        int[][] result = new int[arr.length][1];

        outputArea.append("原始一维数组： " + Arrays.toString(arr) + "\n\n");
        outputArea.append("插入过程：\n");

        for (int i = 0; i < arr.length; i++) {
            // 把已有元素整体往下推一行
            for (int j = i; j > 0; j--) {
                result[j][0] = result[j - 1][0];
            }
            // 新元素放到第一行
            result[0][0] = arr[i];

            // 显示当前已插入的顺序
            outputArea.append("第 " + (i + 1) + " 次插入 " + arr[i] + " 后： ");
            for (int k = 0; k < arr.length; k++) {
                if (k <= i) {
                    outputArea.append(result[k][0] + " ");
                } else {
                    outputArea.append("_ ");
                }
            }
            outputArea.append("\n");
        }

        outputArea.append("\n最终二维数组（每行一个元素）：\n");
        for (int i = 0; i < result.length; i++) {
            outputArea.append("[" + result[i][0] + "]\n");
        }

        outputArea.append("\n最终顺序： ");
        for (int i = 0; i < result.length; i++) {
            outputArea.append(result[i][0] + " ");
        }
        outputArea.append("\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TwoDArrayUI::new);
    }
}