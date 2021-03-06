import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kv")
public class class304 extends NameableContainer {
   @ObfuscatedName("o")
   @Export("tt")
   static int[] tt;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Llt;"
   )
   final JagexLoginType field3848;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1956826059
   )
   int field3847;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public class220 field3849;

   @ObfuscatedSignature(
      signature = "(Llt;)V"
   )
   public class304(JagexLoginType var1) {
      super(400);
      this.field3847 = 1;
      this.field3849 = new class220();
      this.field3848 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lkm;",
      garbageValue = "-2116343302"
   )
   Nameable vmethod5562() {
      return new Friend();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)[Lkm;",
      garbageValue = "164976155"
   )
   Nameable[] vmethod5575(int var1) {
      return new Friend[var1];
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lko;ZB)Z",
      garbageValue = "91"
   )
   public boolean method5519(Name var1, boolean var2) {
      Friend var3 = (Friend)this.method5452(var1);
      return var3 == null?false:!var2 || var3.world != 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgy;IB)V",
      garbageValue = "-3"
   )
   public void method5516(Buffer var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            boolean var3 = var1.readUnsignedByte() == 1;
            Name var4 = new Name(var1.readString(), this.field3848);
            Name var5 = new Name(var1.readString(), this.field3848);
            int var6 = var1.readUnsignedShort();
            int var7 = var1.readUnsignedByte();
            int var8 = var1.readUnsignedByte();
            boolean var9 = (var8 & 2) != 0;
            boolean var10 = (var8 & 1) != 0;
            if(var6 > 0) {
               var1.readString();
               var1.readUnsignedByte();
               var1.readInt();
            }

            var1.readString();
            if(var4 != null && var4.method5533()) {
               Friend var11 = (Friend)this.method5414(var3?var5:var4);
               if(var11 != null) {
                  this.method5437(var11, var4, var5);
                  if(var6 != var11.world) {
                     boolean var12 = true;

                     for(class308 var13 = (class308)this.field3849.method4174(); var13 != null; var13 = (class308)this.field3849.method4180()) {
                        if(var13.field3863.equals(var4)) {
                           if(var6 != 0 && var13.field3864 == 0) {
                              var13.method4183();
                              var12 = false;
                           } else if(var6 == 0 && var13.field3864 != 0) {
                              var13.method4183();
                              var12 = false;
                           }
                        }
                     }

                     if(var12) {
                        this.field3849.method4175(new class308(var4, var6));
                     }
                  }
               } else {
                  if(this.getCount() >= 400) {
                     continue;
                  }

                  var11 = (Friend)this.method5467(var4, var5);
               }

               if(var6 != var11.world) {
                  var11.field3840 = ++this.field3847 - 1;
                  if(var11.world == -1 && var6 == 0) {
                     var11.field3840 = -(var11.field3840 * 1994994117) * 210445581;
                  }

                  var11.world = var6;
               }

               var11.rank = var7;
               var11.field3854 = var9;
               var11.field3855 = var10;
               continue;
            }

            throw new IllegalStateException();
         }

         this.method5421();
         return;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Lje;",
      garbageValue = "52"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.identKits.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class2.identKit_ref.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         KitDefinition.identKits.put(var1, (long)var0);
         return var1;
      }
   }
}
