package evilcraft.network;

import io.netty.buffer.ByteBuf;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.world.World;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientCustomPacketEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerCustomPacketEvent;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evilcraft.EvilCraft;
import evilcraft.GeneralConfig;
import evilcraft.api.Helpers;
import evilcraft.render.particle.EntityFartFX;

/**
 * Instances of this class handles receiving {@link FartPacket}S
 * at both client and server side.
 * 
 * @author immortaleeb
 *
 */
public class FartPacketHandler {
	
	private static final int FART_RANGE = 3000;
    private static final int MAX_PARTICLES = 200;
    private static final int MIN_PARTICLES = 100;
    
    private static final float CLIENT_PLAYER_Y_OFFSET = -0.8f;
    private static final float REMOTE_PLAYER_Y_OFFSET = 0.65f;

    // List of players that have rainbow farts
    private static final String[] ALLOW_RAINBOW_FARTS = { "kroeserr", "_EeB_" };
    
    /**
     * Handles the receiving fart packets at the client side.
     * It basically just spawns particles around the bottom
     * of the player who generated the fart.
     * 
     * @param event Event that contains data about the fart packet.
     */
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onClientPacketReceived(ClientCustomPacketEvent event) {
    	EntityPlayer player = Minecraft.getMinecraft().thePlayer;
    	
    	if (event.packet.payload().readableBytes() > 0) {
           handleClientFartPacket(player, event.packet);
    	}
    }

    /**
     * Handles the receiving fart packets at the server side.
     * Whenever a client sends a fart packet to the server, 
     * the server will just send the packet back to all players
     * who are standing around the player who spawned the fart
     * within a specific range.
     * 
     * @param event Event that contains data about the fart packet.
     */
	@SubscribeEvent
	public void onServerPacketReceived(ServerCustomPacketEvent event) {
		if(GeneralConfig.farting) {
			EntityPlayer player = ((NetHandlerPlayServer) event.handler).playerEntity;
	    	
	    	EvilCraft.channel.sendToAllAround(
	    			FartPacket.createFartPacket(player),
	    			Helpers.createTargetPointFromEntityPosition(player, FART_RANGE)
	    	);
		}
	}
	
	private void handleClientFartPacket(EntityPlayer player, FMLProxyPacket packet) {
		if(GeneralConfig.farting) {
			ByteBuf buffer = packet.payload();
			World world = player.worldObj;
			 
			// Read username
			String username = ByteBufUtils.readUTF8String(packet.payload());
			boolean isRemotePlayer = !player.getDisplayName().equals(username);
	         
			if (isRemotePlayer) { 
				player = world.getPlayerEntityByName(username);
				
				// Read position of the player
				double posX = buffer.readDouble();
				double posY = buffer.readDouble();
				double posZ = buffer.readDouble();
				
				spawnFartParticles(world, player, posX, posY, posZ, true);
			} else {
				spawnFartParticles(world, player, false);
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
    private void spawnFartParticles(World world, EntityPlayer player, boolean isRemotePlayer) {
        spawnFartParticles(world, player, player.posX, player.posY, player.posZ, isRemotePlayer);
    }
    
    @SideOnly(Side.CLIENT)
    private void spawnFartParticles(
            World world, EntityPlayer player, 
            double posX, double posY, double posZ, boolean isRemotePlayer) {
        
        if (player == null)
            return;
        
        Random rand = world.rand;
        int numParticles = rand.nextInt(MAX_PARTICLES - MIN_PARTICLES) + MIN_PARTICLES;
        boolean rainbow = hasRainbowFart(player);
        
        // Make corrections for the player rotation
        double yaw = (player.rotationYaw * Math.PI) / 180;
        double playerXOffset = Math.sin(yaw) * 0.7;
        double playerZOffset = -Math.cos(yaw) * 0.7;
        
        // Make corrections for the location of the player's bottom
        float playerYOffset = isRemotePlayer ? REMOTE_PLAYER_Y_OFFSET : CLIENT_PLAYER_Y_OFFSET;
        
        for (int i=0; i < numParticles; i++) {
            double extraDistance = rand.nextFloat() % 0.3;
            
            double particleX = posX + playerXOffset + extraDistance;
            double particleY = posY + playerYOffset;
            double particleZ = posZ + playerZOffset + extraDistance;
            
            float particleMotionX = -0.5F + rand.nextFloat();
            float particleMotionY = -0.5F + rand.nextFloat();
            float particleMotionZ = -0.5F + rand.nextFloat();
            
            Minecraft.getMinecraft().effectRenderer.addEffect(new EntityFartFX(world, particleX, particleY, particleZ, particleMotionX, particleMotionY, particleMotionZ, rainbow));
        }
    }
    
    /**
     * Check if the given player should have rainbow farts.
     * @param player The player to check.
     * @return If that player has rainbow farts.
     */
    public boolean hasRainbowFart(EntityPlayer player) {
        for (String name : ALLOW_RAINBOW_FARTS) {
            if (name.equals(player.getCommandSenderName()))
                return true;
        }
        
        return false;
    }
}
