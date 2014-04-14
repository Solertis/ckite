package ckite.example

import java.util.concurrent.ConcurrentHashMap
import ckite.rpc.Command
import ckite.statemachine.StateMachine
import ckite.util.Serializer
import java.util.concurrent.atomic.AtomicLong
import java.nio.ByteBuffer

class KVStore extends StateMachine {

  val map = new ConcurrentHashMap[String, String]()
  
  def apply = {
    case Get(key) => map.get(key)
    case Put(key:String,value:String) => map.put(key,value); value
  }
 
  def deserialize(byteBuffer: ByteBuffer) = {
      val snapshotBytes = byteBuffer.array()
	  val deserializedMap:ConcurrentHashMap[String, String] = Serializer.deserialize[ConcurrentHashMap[String, String]](snapshotBytes)
	  map.clear()
	  map.putAll(deserializedMap)
  }

  def serialize(): ByteBuffer = ByteBuffer.wrap(Serializer.serialize(map))

}