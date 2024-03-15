import java.io.*;

public class LeakyBucket {
    public static void main(String[] args) throws IOException {
        int b_size, out_rate, p_size, discard, cnt, outcnt, clkcnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the bucket size");
        b_size = Integer.parseInt(br.readLine());

        System.out.println("Enter the output rate");
        out_rate = Integer.parseInt(br.readLine());

        System.out.println("Enter the number of packets");
        p_size = Integer.parseInt(br.readLine());

        if (p_size > b_size) {
            discard = p_size - b_size;
            p_size = b_size;
            System.out.println("Packets are more so " + discard + " packets are discarded");
        }

        System.out.println("Input packet");
        int[] packets = new int[p_size];
        for (cnt = 0; cnt < p_size; cnt++) {
            packets[cnt] = Integer.parseInt(br.readLine());
        }

        for (cnt = 0; cnt < p_size; clkcnt++) {
            System.out.println("At time tick " +clkcnt);
            for (outcnt = 0; outcnt < out_rate; outcnt++) {
                if (cnt < p_size) {
                    System.out.println("Packet " + packets[cnt] + " drained out");
                    cnt++;
                } else {
                    break;
                }
            }
        }
    }
}
